# Custom Tools
See the Modrinth page (Coming soon) for a complete description of how to use the data pack, this README covers how to use the helper script to modify this datapack and add your own custom textures.

### Running CustomToolsHelper
To run CustomToolsHelper, you will need ``CustomToolsHelper.class``, which you can downoad from here or compile yourself from ``CustomToolsHelper.java``, also found here.
You will also need a settings file, the default is ``CustomToolsSettings.txt``, which you can download here.
If you download ``CustomToolsSettings.txt``, you will need to replace a couple lines with the paths to the data pack and the resource pack (See below for specifics)
To run the script, open a command line in the folder/directory where both the script and settings files are and run ``java CustomToolsHelper CustomToolsSettings.txt``, replacing ``CustomToolsSettings.txt`` if you have a different settings file.

### CustomToolsSettings format:
The CustomToolsSettings file is organized into sections, each beginning with a header and usually ending with an ``END`` line. The order of these sections does not matter, as long as they are all there.

#### ``DATAPACK_PATH`` and ``RESOURCE_PACK_PATH``
These are the only sections you need to modify if you are using the default settings (which I'm not sure why you'd do that because you can just download the defualt settings here or on Modrinth). These are both only one line, so they don't need an ``END`` line. ``DATAPACK_PATH`` contains, as the placeholder suggests, a file path to the root folder of the datapack. This is where the script will write datapack files to. ``RESOURCE_PACK_PATH`` is the same, but the path to the resource pack instead.

#### ``TOOL_MATERIALS``

```
DATAPACK_PATH
# Replace with the path to the root folder of the datapack (.../Custom Tools 1.0 (DP))

RESOURCE_PACK_PATH
# Replace with the path to the root folder of the resource pack (.../Custom Tools 1.0 (RP))

TOOL_MATERIALS
<Material Name>
[<...>]
END

TOOL_TYPES
<Tool Name>
[<...>]
END


HEAD_MATERIALS
<material_name>:<Double Digit ID>:[<Crafting Component>]
[<...>]
END

HANDLE_MATERIALS
<material_name>:<Double Digit ID>:[<Crafting Component>[{<CustomModelData ID>}]]
[<...>]
END

TRIM_MATERIALS
amethyst:01:Amethyst Shard
copper:02:Copper Ingot
diamond:03:Diamond
emerald:04:Emerald
golden:05:Gold Ingot
iron:06:Iron Ingot
lapis:07:Lapis Lazuli
netherite:08:Netherite Ingot
quartz:09:Nether Quartz
redstone:10:Redstone Dust
END

STICKS
oak:1:Oak Log
birch:2:Birch Log
spruce:3:Spruce Log
jungle:4:Jungle Log
acacia:5:Acacia Log
dark_oak:6:Dark Oak Log
mangrove:7:Mangrove Log
cherry:8:Cherry Log
warped:10:Warped Stem
crimson:11:Crimson Stem
netherite:14:Netherite Ingot
stripped_oak:15:Stripped Oak Log
stripped_birch:16:Stripped Birch Log
stripped_spruce:17:Stripped Spruce Log
stripped_jungle:18:Stripped Jungle Log
stripped_acacia:19:Stripped Acacia Log
stripped_dark_oak:20:Stripped Dark Oak Log
stripped_mangrove:21:Stripped Mangrove Log
stripped_cherry:22:Stripped Cherry Log
stripped_warped:23:Stripped Warped Stem
stripped_crimson:24:Stripped Crimson Stem
END
```
