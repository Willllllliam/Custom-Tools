import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomToolsHelper {
  
  private static String DATAPACK_PATH = "DATAPACK_PATH";
  private static String RESOURCE_PACK_PATH = "RESOURCE_PACK_PATH";
  private static String TOOL_MATERIALS = "TOOL_MATERIALS";
  private static String TOOL_TYPES = "TOOL_TYPES";
  private static String HEAD_MATERIALS = "HEAD_MATERIALS";
  private static String HANDLE_MATERIALS = "HANDLE_MATERIALS";
  private static String STICKS = "STICKS";
  private static String TRIM_MATERIALS = "TRIM_MATERIALS";
  private static String END = "END";

  static String dpPath = "";
  static String rpPath = "";
  static ArrayList<String> toolMaterials = new ArrayList<String>();
  static ArrayList<String> toolTypes = new ArrayList<String>();
  static ArrayList<String> headMaterials = new ArrayList<String>();
  static ArrayList<String> headIds = new ArrayList<String>();
  static ArrayList<String> headCraftingComponents = new ArrayList<String>();
  static ArrayList<String> handleMaterials = new ArrayList<String>();
  static ArrayList<String> handleIds = new ArrayList<String>();
  static ArrayList<String> handleCraftingComponents = new ArrayList<String>();
  static ArrayList<String> stickMaterials = new ArrayList<String>();
  static ArrayList<String> stickIds = new ArrayList<String>();
  static ArrayList<String> stickCraftingComponents = new ArrayList<String>();
  static ArrayList<String> trimMaterials = new ArrayList<String>();
  static ArrayList<String> trimIds = new ArrayList<String>();
  static ArrayList<String> trimCraftingComponents = new ArrayList<String>();

  public static void main(String[] args) {
    String jobFile = args[0];

    ArrayList<String> job = importFile(jobFile);
    if (job == null) {
      System.exit(0);
    }

    System.out.println("Job " + jobFile + " loaded, reading...");

    loadSettings(job);
    createModels();
    System.out.println("[Info] Model files done, creating datapack files...");
    createDP();
    System.out.println("[Info] Done!");
  }
  
  
  



  
  public static void createModels() {
    // Create stick.json
    try {
      File fileFile = null;
      if (rpPath.endsWith("/")) {
        fileFile = new File(rpPath + "assets/minecraft/models/item/stick.json");
      } else {
        fileFile = new File(rpPath + "/assets/minecraft/models/item/stick.json");
      }
      fileFile.getParentFile().mkdirs();
      FileWriter file = new FileWriter(fileFile);
      file.write("{\n" + //
                 "\"parent\": \"minecraft:item/handheld\",\n" + //
                 "\"textures\": {\n" + //
                 "\"layer0\": \"minecraft:item/stick\"\n" + //
                 "},\n" + //
                 "\"overrides\": [\n");
      for (int stickIdx = 0; stickIdx < stickMaterials.size(); stickIdx++) {
        file.append("{\"predicate\": {\"custom_model_data\": " + stickIds.get(stickIdx) + "}, \"model\": \"minecraft:item/" + stickMaterials.get(stickIdx) + "_stick\"}");
        if (stickIdx < stickMaterials.size()-1) {
          file.append(",\n");
        }
      }
      file.append("\n]\n}");
      file.close();
      System.out.println("stick.json created.");
    } catch (Exception e) {
      System.out.println("Error creating file stick.json");
    }

    // Create custom stick model files
    for (int stickIdx = 0; stickIdx < stickMaterials.size(); stickIdx++) {
      String fileName = stickMaterials.get(stickIdx) + "_stick.json";
      try {                                                                    // Create model file for this combination
        File fileFile = null;
        if (rpPath.endsWith("/")) {
          fileFile = new File(rpPath + "assets/minecraft/models/item/" + fileName);
        } else {
          fileFile = new File(rpPath + "/assets/minecraft/models/item/" + fileName);
        }
        fileFile.getParentFile().mkdirs();
        FileWriter file = new FileWriter(fileFile);
        file.write("{\n" + //
                    "\"parent\": \"minecraft:item/handheld\",\n" + //
                    "\"textures\": {\n" + //
                    "\"layer0\": \"minecraft:item/" + stickMaterials.get(stickIdx) + "_stick\"\n" + //
                    "}\n" + //
                    "}");
        file.close();
        System.out.println(fileName + " created.");
      } catch (IOException ioe) {
        System.out.println("Error creating file " + fileName);
      }
    }

    // Create vanilla model files
    for (int toolIdx = 0; toolIdx < toolTypes.size(); toolIdx++) {
      int headIdx = 0;
      for (int materialIdx = 0; materialIdx < toolMaterials.size(); materialIdx++) { // Loop over vanilla tool/material combinations
        String vanillaFileName = toolMaterials.get(materialIdx).toLowerCase() + "_" + toolTypes.get(toolIdx).toLowerCase() + ".json"; // Create primary model file for vanilla tool
        try {                                                                                   // (Content will be added in inner loop)
          File vFileFile = null;
          if (rpPath.endsWith("/")) {
            vFileFile = new File(rpPath + "assets/minecraft/models/item/" + vanillaFileName);
          } else {
            vFileFile = new File(rpPath + "/assets/minecraft/models/item/" + vanillaFileName);
          }
          vFileFile.getParentFile().mkdirs();
          FileWriter vFile = new FileWriter(vFileFile);
          // Write the beginning of the vanilla model file (rest will be added in and after inner loop)
          vFile.write("{\n" + //
                      "\"parent\": \"minecraft:item/handheld\",\n" + //
                      "\"textures\": {\n" + //
                      "\"layer0\": \"minecraft:item/" + toolMaterials.get(materialIdx).toLowerCase() + "_" + toolTypes.get(toolIdx).toLowerCase() + "\"\n" + //
                      "},\n" + //
                      "\"overrides\": [\n" + //
                      "{\"predicate\": {\"custom_model_data\": 1" + headIds.get(headIdx) + handleIds.get(0) + "00" + "}, \"model\": \"minecraft:item/" + headMaterials.get(headIdx) + "_" + toolTypes.get(toolIdx).toLowerCase() + "_" + handleMaterials.get(0) + "_handle\"}");

          for (int handleIdx = 0; handleIdx < handleMaterials.size(); handleIdx++) { // Loop over custom head/handle combinations
            for (int trimIdx = 0; trimIdx < trimMaterials.size(); trimIdx++) { // Loop over custom trim combinations
              if (handleIdx == 0 && trimIdx == 0) { // Skip the first case that was written in the beggining portion of the vanilla model file
                continue;
              }
              if (trimIdx == 0) {
                vFile.append(",\n{\"predicate\": {\"custom_model_data\": 1" + headIds.get(headIdx) + handleIds.get(handleIdx) + trimIds.get(trimIdx) + "}, \"model\": \"minecraft:item/" + headMaterials.get(headIdx) + "_" + toolTypes.get(toolIdx).toLowerCase() + "_" + handleMaterials.get(handleIdx) + "_handle\"}");
              } else {
                vFile.append(",\n{\"predicate\": {\"custom_model_data\": 1" + headIds.get(headIdx) + handleIds.get(handleIdx) + trimIds.get(trimIdx) + "}, \"model\": \"minecraft:item/" + headMaterials.get(headIdx) + "_" + toolTypes.get(toolIdx).toLowerCase() + "_" + handleMaterials.get(handleIdx) + "_handle_" + trimMaterials.get(trimIdx) + "_trim\"}");
              }
            }
          } // This initial loop is to get headIdx off of the trigger value of "00"
          headIdx++;
          try {
            while (!headIds.get(headIdx).equals("00")) {
              for (int handleIdx = 0; handleIdx < handleMaterials.size(); handleIdx++) { // Loop over custom head/handle combinations
                for (int trimIdx = 0; trimIdx < trimMaterials.size(); trimIdx++) {
                  if (headIdx == 0 && handleIdx == 0 && trimIdx == 0) { // Skip the first case that was written in the beggining portion of the vanilla model file
                    continue;
                  }
                  if (trimIdx == 0) {
                    vFile.append(",\n{\"predicate\": {\"custom_model_data\": 1" + headIds.get(headIdx) + handleIds.get(handleIdx) + trimIds.get(trimIdx) + "}, \"model\": \"minecraft:item/" + headMaterials.get(headIdx) + "_" + toolTypes.get(toolIdx).toLowerCase() + "_" + handleMaterials.get(handleIdx) + "_handle\"}");
                  } else {
                    vFile.append(",\n{\"predicate\": {\"custom_model_data\": 1" + headIds.get(headIdx) + handleIds.get(handleIdx) + trimIds.get(trimIdx) + "}, \"model\": \"minecraft:item/" + headMaterials.get(headIdx) + "_" + toolTypes.get(toolIdx).toLowerCase() + "_" + handleMaterials.get(handleIdx) + "_handle_" + trimMaterials.get(trimIdx) + "_trim\"}");
                  }
                }
              }
              headIdx++;
            } // End inner loop
          } catch (IndexOutOfBoundsException iobe) {}

          vFile.append("\n]\n}"); // Write end of vanilla model file and close it
          vFile.close();
          System.out.println(vanillaFileName + " created.");
        } catch (Exception e) {
          System.out.println("Error creating file " + vanillaFileName);
        }
      } // End outer loop
    }   //

    // Create custom model files
    for (int toolIdx = 0; toolIdx < toolTypes.size(); toolIdx++) {
      for (int headIdx = 0; headIdx < headMaterials.size(); headIdx++) {
        for (int handleIdx = 0; handleIdx < handleMaterials.size(); handleIdx++) { // Loop over custom head/handle combinations
          for (int trimIdx = 0; trimIdx < trimMaterials.size(); trimIdx++) { // Loop over trims
            String fileName = "";
            if (trimIds.get(trimIdx).equals("00")) {
              fileName = headMaterials.get(headIdx) + "_" + toolTypes.get(toolIdx).toLowerCase() + "_" + handleMaterials.get(handleIdx) + "_handle.json";
            } else {
              fileName = headMaterials.get(headIdx) + "_" + toolTypes.get(toolIdx).toLowerCase() + "_" + handleMaterials.get(handleIdx) + "_handle_" + trimMaterials.get(trimIdx) + "_trim.json";
            }
            try {                                                                    // Create model file for this combination
              File fileFile = null;
              if (rpPath.endsWith("/")) {
                fileFile = new File(rpPath + "assets/minecraft/models/item/" + fileName);
              } else {
                fileFile = new File(rpPath + "/assets/minecraft/models/item/" + fileName);
              }
              fileFile.getParentFile().mkdirs();
              FileWriter file = new FileWriter(fileFile);
              if (trimIds.get(trimIdx).equals("00")) {
                file.write("{\n" + //
                           "\"parent\": \"minecraft:item/handheld\",\n" + //
                           "\"textures\": {\n" + //
                           "\"layer0\": \"minecraft:item/" + handleMaterials.get(handleIdx) + "_" + toolTypes.get(toolIdx).toLowerCase() + "_handle\",\n" + //
                           "\"layer1\": \"minecraft:item/" + headMaterials.get(headIdx) + "_" + toolTypes.get(toolIdx).toLowerCase() + "_head\"\n" + //
                           "}\n" + //
                           "}");
              } else if (trimMaterials.get(trimIdx).equals(headMaterials.get(headIdx))) {
                file.write("{\n" + //
                           "\"parent\": \"minecraft:item/handheld\",\n" + //
                           "\"textures\": {\n" + //
                           "\"layer0\": \"minecraft:item/" + handleMaterials.get(handleIdx) + "_" + toolTypes.get(toolIdx).toLowerCase() + "_handle\",\n" + //
                           "\"layer1\": \"minecraft:item/" + headMaterials.get(headIdx) + "_" + toolTypes.get(toolIdx).toLowerCase() + "_head\",\n" + //
                           "\"layer2\": \"minecraft:item/" + trimMaterials.get(trimIdx) + "_darker_" + toolTypes.get(toolIdx).toLowerCase() + "_trim\"\n" + //
                           "}\n" + //
                           "}");
              } else {
                file.write("{\n" + //
                           "\"parent\": \"minecraft:item/handheld\",\n" + //
                           "\"textures\": {\n" + //
                           "\"layer0\": \"minecraft:item/" + handleMaterials.get(handleIdx) + "_" + toolTypes.get(toolIdx).toLowerCase() + "_handle\",\n" + //
                           "\"layer1\": \"minecraft:item/" + headMaterials.get(headIdx) + "_" + toolTypes.get(toolIdx).toLowerCase() + "_head\",\n" + //
                           "\"layer2\": \"minecraft:item/" + trimMaterials.get(trimIdx) + "_" + toolTypes.get(toolIdx).toLowerCase() + "_trim\"\n" + //
                           "}\n" + //
                           "}");
              }
              file.close();
              System.out.println(fileName + " created.");
            } catch (IOException ioe) {
              System.out.println("Error creating file " + fileName);
            }
          }
        }
      }
    }

  }







  public static void createDP() {
    // Create load.mcfunction
    try {
      File fileFile = null;
      if (dpPath.endsWith("/")) {
        fileFile = new File(dpPath + "data/ct/functions/load.mcfunction");
      } else {
        fileFile = new File(dpPath + "/data/ct/functions/load.mcfunction");
      }
      fileFile.getParentFile().mkdirs();
      FileWriter file = new FileWriter(fileFile);
      file.write("scoreboard objectives add constant dummy\n" + //
                 "scoreboard players set 1 constant 1\n" + //
                 "scoreboard players set 1000000 constant 1000000\n" + //
                 "\n" + //
                 "scoreboard objectives add value dummy\n" + //
                 "scoreboard objectives add held_value dummy\n" + //
                 "\n" + //
                 "scoreboard objectives add cthelp trigger\n" + //
                 "scoreboard objectives add ctsticks trigger\n" + //
                 "scoreboard objectives add ctheads trigger\n" + //
                 "scoreboard objectives add ctwoodenheads trigger\n" + //
                 "scoreboard objectives add ctstoneheads trigger\n" + //
                 "scoreboard objectives add ctironheads trigger\n" + //
                 "scoreboard objectives add ctdiamondheads trigger\n" + //
                 "scoreboard objectives add ctnetheriteheads trigger\n" + //
                 "scoreboard objectives add cthandles trigger\n" + //
                 "scoreboard objectives add cttrims trigger\n" + //
                 "scoreboard objectives add ctexample trigger\n" + //
                 "scoreboard objectives add ctsteps trigger");
      file.close();
      System.out.println("load.mcfunction created.");
    } catch (Exception e) {
      System.out.println("Error creating file load.mcfunction");
    }
    
    // Initialize list to store the info for the check_<material>_head.mcfunction files in so they don't need to be calculated again
    ArrayList<String> check_head_files = new ArrayList<String>();
    ArrayList<Integer> headMaterialIdxs = new ArrayList<Integer>();
    
    // Create tick.mcfunction
    try {
      File fileFile = null;
      if (dpPath.endsWith("/")) {
        fileFile = new File(dpPath + "data/ct/functions/tick.mcfunction");
      } else {
        fileFile = new File(dpPath + "/data/ct/functions/tick.mcfunction");
      }
      fileFile.getParentFile().mkdirs();
      FileWriter file = new FileWriter(fileFile);
      file.write("schedule function ct:tick 1t\n" + //
                 "\n" + //
                 "execute as @e[type=item, name=\"Stick\"] at @s if block ~ ~-1 ~ crafting_table if entity @a[distance=..5] run function ct:craft_stick\n" + //
                 "\n");
      int headIdx = 0;
      for (int materialIdx = 0; materialIdx < toolMaterials.size(); materialIdx++) {
        while (!headIds.get(headIdx).equals("00")) {
          headIdx++;
        }
        headMaterialIdxs.add(headIdx);
        if (headIdx < headIds.size()-1) {
          if (!headIds.get(headIdx+1).equals("00")) {
            for (int toolIdx = 0; toolIdx < toolTypes.size(); toolIdx++) {
              file.append("execute as @e[type=item, name=\"" + toolMaterials.get(materialIdx) + " " + toolTypes.get(toolIdx) + "\", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_" + toolMaterials.get(materialIdx).toLowerCase() + "_heads\n");
            }
          check_head_files.add("check_" + toolMaterials.get(materialIdx).toLowerCase() + "_heads.mcfunction");
          } else {
            check_head_files.add("");
          }
        }
        headIdx++;
      }
      file.append("\n");
      for (int materialIdx = 0; materialIdx < toolMaterials.size(); materialIdx++) {
        for (int toolIdx = 0; toolIdx < toolTypes.size(); toolIdx++) {
          file.append("execute as @e[type=item, name=\"" + toolMaterials.get(materialIdx) + " " + toolTypes.get(toolIdx) + "\", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles\n");
        }
      }
      file.append("\n");
      for (int materialIdx = 0; materialIdx < toolMaterials.size(); materialIdx++) {
        for (int toolIdx = 0; toolIdx < toolTypes.size(); toolIdx++) {
          file.append("execute as @e[type=item, name=\"" + toolMaterials.get(materialIdx) + " " + toolTypes.get(toolIdx) + "\", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims\n");
        }
      }
      file.append("\n" + //
                 "scoreboard players enable @a cthelp\n" + //
                 "execute as @a[scores={cthelp=1}] run function ct:help/cthelp\n" + //
                 "scoreboard players enable @a ctsticks\n" + //
                 "execute as @a[scores={ctsticks=1}] run function ct:help/ctsticks\n" + //
                 "scoreboard players enable @a ctheads\n" + //
                 "execute as @a[scores={ctheads=1}] run function ct:help/ctheads\n" + //
                 "scoreboard players enable @a ctwoodenheads\n" + //
                 "execute as @a[scores={ctwoodenheads=1}] run function ct:help/ctwoodenheads\n" + //
                 "scoreboard players enable @a ctstoneheads\n" + //
                 "execute as @a[scores={ctstoneheads=1}] run function ct:help/ctstoneheads\n" + //
                 "scoreboard players enable @a ctironheads\n" + //
                 "execute as @a[scores={ctironheads=1}] run function ct:help/ctironheads\n" + //
                 "scoreboard players enable @a ctdiamondheads\n" + //
                 "execute as @a[scores={ctdiamondheads=1}] run function ct:help/ctdiamondheads\n" + //
                 "scoreboard players enable @a ctnetheriteheads\n" + //
                 "execute as @a[scores={ctnetheriteheads=1}] run function ct:help/ctnetheriteheads\n" + //
                 "scoreboard players enable @a cthandles\n" + //
                 "execute as @a[scores={cthandles=1}] run function ct:help/cthandles\n" + //
                 "scoreboard players enable @a cttrims\n" + //
                 "execute as @a[scores={cttrims=1}] run function ct:help/cttrims\n" + //
                 "scoreboard players enable @a ctexample\n" + //
                 "execute as @a[scores={ctexample=1}] run function ct:help/ctexample\n" + //
                 "scoreboard players enable @a ctsteps\n" + //
                 "execute as @a[scores={ctsteps=1}] run function ct:help/ctsteps");
      file.close();
      System.out.println("tick.mcfunction created.");
    } catch (Exception e) {
      System.out.println("Error creating file tick.mcfunction");
    }

    // Add the end of the list to the head material indeces to avoid out of bounds error when looking ahead
    headMaterialIdxs.add(headMaterials.size());

    // Create craft_stick.mcfunction
    try {
      File fileFile = null;
      if (dpPath.endsWith("/")) {
        fileFile = new File(dpPath + "data/ct/functions/craft_stick.mcfunction");
      } else {
        fileFile = new File(dpPath + "/data/ct/functions/craft_stick.mcfunction");
      }
      fileFile.getParentFile().mkdirs();
      FileWriter file = new FileWriter(fileFile);
      for (int stickIdx = 0; stickIdx < stickMaterials.size(); stickIdx++) {
        file.append("execute if entity @e[type=item, name=\"" + stickCraftingComponents.get(stickIdx) + "\", distance=..0.5] if entity @s[nbt=!{Item:{tag:{CustomModelData:" + stickIds.get(stickIdx) + "}}}] run data merge entity @s {Item:{tag:{CustomModelData:" + stickIds.get(stickIdx) + "}}}\n");
      }
      file.close();
      System.out.println("craft_stick.mcfunction created.");
    } catch (Exception e) {
      System.out.println("Error creating file craft_stick.mcfunction");
    }

    // Create check_<material>_heads.mcfunction files
    for (int fileIdx = 0; fileIdx < check_head_files.size(); fileIdx++) {
      if (check_head_files.get(fileIdx).equals("")) {
        continue;
      }
      try {
        File fileFile = null;
        if (dpPath.endsWith("/")) {
          fileFile = new File(dpPath + "data/ct/functions/" + check_head_files.get(fileIdx));
        } else {
          fileFile = new File(dpPath + "/data/ct/functions/" + check_head_files.get(fileIdx));
        }
        fileFile.getParentFile().mkdirs();
        FileWriter file = new FileWriter(fileFile);
        for (int headIdx = headMaterialIdxs.get(fileIdx); headIdx < headMaterialIdxs.get(fileIdx+1); headIdx++) {
          if (!headCraftingComponents.get(headIdx).equals("")) {
            file.append("execute if entity @e[type=item, name=\"" + headCraftingComponents.get(headIdx) + "\", distance=..0.5] run function ct:craft_head {item:'" + headCraftingComponents.get(headIdx) + "', head_id:'" + headIds.get(headIdx) + "'}\n");
          }
        }
        file.close();
        System.out.println(check_head_files.get(fileIdx) + " created.");
      } catch (Exception e) {
        System.out.println("Error creating file " + check_head_files.get(fileIdx));
      }
    }

    // Create craft_head.mcfunction
    try {
      File fileFile = null;
      if (dpPath.endsWith("/")) {
        fileFile = new File(dpPath + "data/ct/functions/craft_head.mcfunction");
      } else {
        fileFile = new File(dpPath + "/data/ct/functions/craft_head.mcfunction");
      }
      fileFile.getParentFile().mkdirs();
      FileWriter file = new FileWriter(fileFile);
      file.write("tag @s add just_reheaded\n" + //
                 "\n" + //
                 "$execute store result score @s value run data get entity @e[type=item, tag=!just_reheaded, name=\"$(item)\", distance=..0.5, limit=1, sort=nearest] Item.Count\n" + //
                 "scoreboard players operation @s value -= 1 constant\n" + //
                 "$execute store result entity @e[type=item, tag=!just_reheaded, name=\"$(item)\", distance=..0.5, limit=1, sort=nearest] Item.Count byte 1 run scoreboard players get @s value\n" + //
                 "\n" + //
                 "execute store result score @s value run data get entity @s Item.tag.CustomModelData\n" + //
                 "scoreboard players operation @s value > 1000000 constant\n" + //
                 "$function ct:replace_digits {score_holder:\"@s\", objective:\"value\", start:\"1000000\", end:\"10000\", value:\"$(head_id)\"}\n" + //
                 "execute store result entity @s Item.tag.CustomModelData int 1 run scoreboard players get @s value");
      file.close();
      System.out.println("craft_head.mcfunction created.");
    } catch (Exception e) {
      System.out.println("Error creating file craft_head.mcfunction");
    }

    // Create check_handles.mcfunction
    try {
      File fileFile = null;
      if (dpPath.endsWith("/")) {
        fileFile = new File(dpPath + "data/ct/functions/check_handles.mcfunction");
      } else {
        fileFile = new File(dpPath + "/data/ct/functions/check_handles.mcfunction");
      }
      fileFile.getParentFile().mkdirs();
      FileWriter file = new FileWriter(fileFile);
      for (int handleIdx = 0; handleIdx < handleMaterials.size(); handleIdx++) {
        if (!handleCraftingComponents.get(handleIdx).equals("")) {
          if (handleCraftingComponents.get(handleIdx).contains("{")) {
            String cc = handleCraftingComponents.get(handleIdx).split("\\{")[0];
            String id = handleCraftingComponents.get(handleIdx).split("\\{")[1].replace("}", "");
            file.append("execute if entity @e[type=item, name=\"" + cc + "\", nbt={Item:{tag:{CustomModelData:" + id + "}}}, distance=..0.5] run function ct:craft_handle {item:'" + cc + "', handle_id:'" + handleIds.get(handleIdx) + "'}\n");
          } else {
            file.append("execute if entity @e[type=item, name=\"" + handleCraftingComponents.get(handleIdx) + "\", distance=..0.5] run function ct:craft_handle {item:'" + handleCraftingComponents.get(handleIdx) + "', handle_id:'" + handleIds.get(handleIdx) + "'}\n");
          }
        }
      }
      file.close();
      System.out.println("check_handles.mcfunction created.");
    } catch (Exception e) {
      System.out.println("Error creating file check_handles.mcfunction");
    }

    // Create craft_handle.mcfunction
    try {
      File fileFile = null;
      if (dpPath.endsWith("/")) {
        fileFile = new File(dpPath + "data/ct/functions/craft_handle.mcfunction");
      } else {
        fileFile = new File(dpPath + "/data/ct/functions/craft_handle.mcfunction");
      }
      fileFile.getParentFile().mkdirs();
      FileWriter file = new FileWriter(fileFile);
      file.write("tag @s add just_rehandled\n" + //
                 "\n" + //
                 "$execute store result score @s value run data get entity @e[type=item, tag=!just_rehandled, name=\"$(item)\", distance=..0.5, limit=1, sort=nearest] Item.Count\n" + //
                 "scoreboard players operation @s value -= 1 constant\n" + //
                 "$execute store result entity @e[type=item, tag=!just_rehandled, name=\"$(item)\", distance=..0.5, limit=1, sort=nearest] Item.Count byte 1 run scoreboard players get @s value\n" + //
                 "\n" + //
                 "execute store result score @s value run data get entity @s Item.tag.CustomModelData\n" + //
                 "scoreboard players operation @s value > 1000000 constant\n" + //
                 "$function ct:replace_digits {score_holder:\"@s\", objective:\"value\", start:\"10000\", end:\"100\", value:\"$(handle_id)\"}\n" + //
                 "execute store result entity @s Item.tag.CustomModelData int 1 run scoreboard players get @s value");
      file.close();
      System.out.println("craft_handle.mcfunction created.");
    } catch (Exception e) {
      System.out.println("Error creating file craft_handle.mcfunction");
    }

    // Create check_trims.mcfunction
    try {
      File fileFile = null;
      if (dpPath.endsWith("/")) {
        fileFile = new File(dpPath + "data/ct/functions/check_trims.mcfunction");
      } else {
        fileFile = new File(dpPath + "/data/ct/functions/check_trims.mcfunction");
      }
      fileFile.getParentFile().mkdirs();
      FileWriter file = new FileWriter(fileFile);
      for (int toolIdx = 0; toolIdx < toolTypes.size(); toolIdx++) {
        for (int materialIdx = 0; materialIdx < toolMaterials.size(); materialIdx++) {
          for (int trimIdx = 0; trimIdx < trimMaterials.size(); trimIdx++) {
            file.append("execute if entity @e[type=item, name=\"" + trimCraftingComponents.get(trimIdx) + "\", distance=..0.5] run function ct:craft_trim {item:'" + trimCraftingComponents.get(trimIdx) + "', trim_id:'" + trimIds.get(trimIdx) + "'}\n");
          }
        }
      }
      file.close();
      System.out.println("check_trims.mcfunction created.");
    } catch (Exception e) {
      System.out.println("Error creating file check_trims.mcfunction");
    }

    // Create craft_trim.mcfunction
    try {
      File fileFile = null;
      if (dpPath.endsWith("/")) {
        fileFile = new File(dpPath + "data/ct/functions/craft_trim.mcfunction");
      } else {
        fileFile = new File(dpPath + "/data/ct/functions/craft_trim.mcfunction");
      }
      fileFile.getParentFile().mkdirs();
      FileWriter file = new FileWriter(fileFile);
      file.write("tag @s add just_retrimmed\n" + //
                 "\n" + //
                 "$execute store result score @s value run data get entity @e[type=item, tag=!just_retrimmed, name=\"$(item)\", distance=..0.5, limit=1, sort=nearest] Item.Count\n" + //
                 "scoreboard players operation @s value -= 1 constant\n" + //
                 "$execute store result entity @e[type=item, tag=!just_retrimmed, name=\"$(item)\", distance=..0.5, limit=1, sort=nearest] Item.Count byte 1 run scoreboard players get @s value\n" + //
                 "\n" + //
                 "execute store result score @s value run data get entity @s Item.tag.CustomModelData\n" + //
                 "scoreboard players operation @s value > 1000000 constant\n" + //
                 "$function ct:replace_digits {score_holder:\"@s\", objective:\"value\", start:\"100\", end:\"1\", value:\"$(trim_id)\"}\n" + //
                 "execute store result entity @s Item.tag.CustomModelData int 1 run scoreboard players get @s value");
      file.close();
      System.out.println("craft_trim.mcfunction created.");
    } catch (Exception e) {
      System.out.println("Error creating file craft_trim.mcfunction");
    }

  }
  





  private static void loadSettings(ArrayList<String> job) {
    System.out.println("Looking for " + DATAPACK_PATH + "...");
    int dpPathIdx = findLineIndex(DATAPACK_PATH, job);
    if (dpPathIdx == -1) {
      System.out.println("[Fail] No " + DATAPACK_PATH + " line found.");
      return;
    }
    if (job.get(dpPathIdx+1).startsWith("#")) {
      System.out.println("[Error] Placeholder text in DATAPACK_PATH, replace with the path of the datapack folder on your computer (should end in /Custom Tools (DP) or similar).");
      System.exit(0);
    }
    dpPath = job.get(dpPathIdx+1);
    System.out.println("[Success] " + DATAPACK_PATH + " found: " + dpPath);
    
    System.out.println("Looking for " + RESOURCE_PACK_PATH + "...");
    int rpPathIdx = findLineIndex(RESOURCE_PACK_PATH, job);
    if (rpPathIdx == -1) {
      System.out.println("[Fail] No " + RESOURCE_PACK_PATH + " line found.");
      return;
    }
    if (job.get(rpPathIdx+1).startsWith("#")) {
      System.out.println("[Error] Placeholder text in RESOURCE_PACK_PATH, replace with the path of the resource pack folder on your computer (should end in /Custom Tools (RP) or similar).");
      System.exit(0);
    }
    rpPath = job.get(rpPathIdx+1);
    System.out.println("[Success] " + RESOURCE_PACK_PATH + " found: " + rpPath);

    System.out.println("Looking for " + TOOL_MATERIALS + "...");
    int toolMaterialsPathIdx = findLineIndex(TOOL_MATERIALS, job);
    if (toolMaterialsPathIdx == -1) {
      System.out.println("[Fail] No " + TOOL_MATERIALS + " line found.");
      return;
    }
    toolMaterials = blockArray(toolMaterialsPathIdx, job);
    System.out.println("[Success] " + TOOL_MATERIALS + " loaded.");

    System.out.println("Looking for " + TOOL_TYPES + "...");
    int toolTypesPathIdx = findLineIndex(TOOL_TYPES, job);
    if (toolTypesPathIdx == -1) {
      System.out.println("[Fail] No " + TOOL_TYPES + " line found.");
      return;
    }
    toolTypes = blockArray(toolTypesPathIdx, job);
    System.out.println("[Success] " + TOOL_TYPES + " loaded.");

    System.out.println("Looking for " + HEAD_MATERIALS + "...");
    int headMaterialsPathIdx = findLineIndex(HEAD_MATERIALS, job);
    if (headMaterialsPathIdx == -1) {
      System.out.println("[Fail] No " + HEAD_MATERIALS + " line found.");
      return;
    }
    ArrayList<String> headMaterialsLines = blockArray(headMaterialsPathIdx, job);
    System.out.println("[Success] " + HEAD_MATERIALS + " loaded.");
    for (String i : headMaterialsLines) {
      String[] c = i.split(":");
      try {
        headMaterials.add(c[0]);
      } catch (IndexOutOfBoundsException ioobe) {
        System.out.println("[Fail] Head Material must be in the format 'name:numeric id:crafting material (optional)'. (Missing name)");
        continue;
      }
      try {
        headIds.add(c[1]);
      } catch (NumberFormatException nfe) {
        System.out.println("[Fail] Head ID must be numeric. (is " + c[1] + ")");
        headMaterials.remove(headMaterials.size()-1);
      } catch (IndexOutOfBoundsException ioobe) {
        System.out.println("[Fail] Head Material must be in the format 'name:numeric id:crafting material (optional)'. (Missing id)");
        headMaterials.remove(headMaterials.size()-1);
        continue;
      }
      try {
        headCraftingComponents.add(c[2]);
        System.out.println("[Success] '" + c[0] + "' loaded with id " + c[1] + ". Crafted with '" + c[2] + "'.");
      } catch (IndexOutOfBoundsException ioobe) {
        headCraftingComponents.add("");
        System.out.println("[Success] '" + c[0] + "' loaded with id " + c[1] + ". Cannot be crafted.");
      }
    }

    System.out.println("Looking for " + HANDLE_MATERIALS + "...");
    int handleMaterialsPathIdx = findLineIndex(HANDLE_MATERIALS, job);
    if (handleMaterialsPathIdx == -1) {
      System.out.println("[Fail] No " + HANDLE_MATERIALS + " line found.");
      return;
    }
    ArrayList<String> handleMaterialsLines = blockArray(handleMaterialsPathIdx, job);
    System.out.println("[Success] " + HANDLE_MATERIALS + " loaded.");
    for (String i : handleMaterialsLines) {
      String[] c = i.split(":");
      try {
        handleMaterials.add(c[0]);
      } catch (IndexOutOfBoundsException ioobe) {
        System.out.println("[Fail] Handle Material must be in the format 'name:numeric id:crafting material (optional)'. (Missing name)");
        continue;
      }
      try {
        handleIds.add(c[1]);
      } catch (NumberFormatException nfe) {
        System.out.println("[Fail] Handle ID must be numeric. (is " + c[1] + ")");
        handleMaterials.remove(handleMaterials.size()-1);
      } catch (IndexOutOfBoundsException ioobe) {
        System.out.println("[Fail] Handle Material must be in the format 'name:numeric id:crafting material (optional)'. (Missing id)");
        handleMaterials.remove(handleMaterials.size()-1);
        continue;
      }
      try {
        handleCraftingComponents.add(c[2]);
        System.out.println("[Success] Handle Material '" + c[0] + "' loaded with id " + c[1] + ". Crafted with '" + c[2] + "'.");
      } catch (IndexOutOfBoundsException ioobe) {
        handleCraftingComponents.add("");
        System.out.println("[Success] Handle Material '" + c[0] + "' loaded with id " + c[1] + ". Cannot be crafted.");
      }
    }

    System.out.println("Looking for " + STICKS + "...");
    int sticksPathIdx = findLineIndex(STICKS, job);
    if (sticksPathIdx == -1) {
      System.out.println("[Fail] No " + STICKS + " line found.");
      return;
    }
    ArrayList<String> sticksLines = blockArray(sticksPathIdx, job);
    System.out.println("[Success] " + STICKS + " loaded.");
    for (String i : sticksLines) {
      String[] c = i.split(":");
      try {
        stickMaterials.add(c[0]);
      } catch (IndexOutOfBoundsException ioobe) {
        System.out.println("[Fail] Sticks must be in the format 'name:numeric id:crafting material (optional)'. (Missing name)");
        continue;
      }
      try {
        stickIds.add(c[1]);
      } catch (NumberFormatException nfe) {
        System.out.println("[Fail] Stick ID must be numeric. (is " + c[1] + ")");
        stickMaterials.remove(stickMaterials.size()-1);
      } catch (IndexOutOfBoundsException ioobe) {
        System.out.println("[Fail] Sticks must be in the format 'name:numeric id:crafting material (optional)'. (Missing id)");
        stickMaterials.remove(stickMaterials.size()-1);
        continue;
      }
      try {
        stickCraftingComponents.add(c[2]);
        System.out.println("[Success] Stick '" + c[0] + "' loaded with id " + c[1] + ". Crafted with '" + c[2] + "'.");
      } catch (IndexOutOfBoundsException ioobe) {
        stickCraftingComponents.add("");
        System.out.println("[Success] Stick '" + c[0] + "' loaded with id " + c[1] + ". Cannot be crafted.");
      }
    }

    System.out.println("Looking for " + TRIM_MATERIALS + "...");
    int trimsPathIdx = findLineIndex(TRIM_MATERIALS, job);
    if (trimsPathIdx == -1) {
      System.out.println("[Fail] No " + TRIM_MATERIALS + " line found.");
      return;
    }
    ArrayList<String> trimsLines = blockArray(trimsPathIdx, job);
    System.out.println("[Success] " + TRIM_MATERIALS + " loaded.");
    trimMaterials.add("");          //
    trimIds.add("00");              // Create "No Trim" id
    trimCraftingComponents.add(""); //
    for (String i : trimsLines) {
      String[] c = i.split(":");
      try {
        trimMaterials.add(c[0]);
      } catch (IndexOutOfBoundsException ioobe) {
        System.out.println("[Fail] Trims must be in the format 'name:numeric id:crafting material (optional)'. (Missing name)");
        continue;
      }
      try {
        trimIds.add(c[1]);
      } catch (NumberFormatException nfe) {
        System.out.println("[Fail] Trim ID must be numeric. (is " + c[1] + ")");
        trimMaterials.remove(trimMaterials.size()-1);
      } catch (IndexOutOfBoundsException ioobe) {
        System.out.println("[Fail] Trims must be in the format 'name:numeric id:crafting material (optional)'. (Missing id)");
        trimMaterials.remove(trimMaterials.size()-1);
        continue;
      }
      try {
        trimCraftingComponents.add(c[2]);
        System.out.println("[Success] Trim '" + c[0] + "' loaded with id " + c[1] + ". Crafted with '" + c[2] + "'.");
      } catch (IndexOutOfBoundsException ioobe) {
        trimCraftingComponents.add("");
        System.out.println("[Success] Trim '" + c[0] + "' loaded with id " + c[1] + ". Cannot be crafted.");
      }
    }

    int totalModels = (toolTypes.size() * headMaterials.size() * handleMaterials.size() * (trimMaterials.size() + 1)) + (toolTypes.size() * toolMaterials.size()) + stickMaterials.size() + 1;
    System.out.println("[Info] " + totalModels + " models to generate...");
  }










  public static ArrayList<String> importFile(String fileName) {
    ArrayList<String> lines = new ArrayList<String>();
      
    try {
      File file = new File(fileName);
      Scanner fileScanner = new Scanner(file);
      while (fileScanner.hasNextLine()) {
        lines.add(fileScanner.nextLine().trim());
      }
      fileScanner.close();
      return lines;
    } catch (FileNotFoundException e) {
      System.out.println("The specified file doesn't exist.");
      return null;
    }
  }

  public static int findLineIndex(String beginsWith, ArrayList<String> parent) {
    if (parent == null) {
      return -1;
    }
    int idx = -1;
    for (int i = 0; i < parent.size(); i++) {
      if (parent.get(i).startsWith(beginsWith)) {
        idx = i;
        break;
      }
    }
    return idx;
  }

  public static int findLineIndex(String beginsWith, ArrayList<String> parent, int start) {
    if (parent == null) {
      return -1;
    }
    int idx = -1;
    for (int i = start; i < parent.size(); i++) {
      if (parent.get(i).startsWith(beginsWith)) {
        idx = i;
        break;
      }
    }
    return idx;
  }

  public static ArrayList<String> blockArray(int start, ArrayList<String> parent) {
    if (start < 0) {
      throw new NullPointerException("Start index must be greater than 0");
    }
    ArrayList<String> array = new ArrayList<String>();
    int i = start+1;
    while (!parent.get(i).equals(END)) {
      array.add(parent.get(i));
      i++;
      if (i >= parent.size()) {
        System.out.println("[Fail] Reached end of file before finding " + END);
        return null;
      }
    }
    return array;
  }

}
