# Custom Tools
See the Modrinth page (Coming soon) for a complete description of how to use the data pack, this README covers how to use the helper script to modify this datapack and add your own custom textures.

### Running CustomToolsHelper
To run CustomToolsHelper, you will need ``CustomToolsHelper.class``, which you can downoad from here or compile yourself from ``CustomToolsHelper.java``, also found here.
You will also need a settings file, the default is ``CustomToolsSettings.txt``, which you can download here.
If you download ``CustomToolsSettings.txt``, you will need to replace a couple lines with the paths to the data pack and the resource pack (See below for specifics)
To run the script, open a command line in the folder/directory where both the script and settings files are and run ``java CustomToolsHelper CustomToolsSettings.txt``, replacing ``CustomToolsSettings.txt`` if you have a different settings file.

### CustomToolsSettings format:
```
DATAPACK_PATH


RESOURCE_PACK_PATH


TOOL_MATERIALS
Wooden
Stone
Iron
Golden
Diamond
Netherite
END

TOOL_TYPES
Axe
Hoe
Pickaxe
Shovel
Sword
END


HEAD_MATERIALS
wooden:00
oak:01:Oak Planks
birch:02:Birch Planks
spruce:03:Spruce Planks
jungle:04:Jungle Planks
acacia:05:Acacia Planks
dark_oak:06:Dark Oak Planks
mangrove:07:Mangrove Planks
cherry:08:Cherry Planks
bamboo:09:Bamboo Planks
warped:10:Warped Planks
crimson:11:Crimson Planks
stone:00:Stone
cobblestone:01:Cobblestone
deepslate:02:Cobbled Deepslate
granite:03:Granite
diorite:04:Diorite
andesite:05:Andesite
tuff:06:Tuff
blackstone:07:Blackstone
iron:00:Iron Ingot
copper:01:Copper Ingot
golden:00
diamond:00:Diamond
emerald:01:Emerald
amethyst:02:Amethyst Shard
netherite:00:Netherite Ingot
scrap:01:Netherite Scrap
echo:02:Echo Shard
END

HANDLE_MATERIALS
wooden:00
oak:01:Stick{1}
birch:02:Stick{2}
spruce:03:Stick{3}
jungle:04:Stick{4}
acacia:05:Stick{5}
dark_oak:06:Stick{6}
mangrove:07:Stick{7}
cherry:08:Stick{8}
bamboo:09:Bamboo
warped:10:Stick{10}
crimson:11:Stick{11}
bone:12:Bone
blaze:13:Blaze Rod
netherite:14:Stick{14}
stripped_oak:15:Stick{15}
stripped_birch:16:Stick{16}
stripped_spruce:17:Stick{17}
stripped_jungle:18:Stick{18}
stripped_acacia:19:Stick{19}
stripped_dark_oak:20:Stick{20}
stripped_mangrove:21:Stick{21}
stripped_cherry:22:Stick{22}
stripped_warped:23:Stick{23}
stripped_crimson:24:Stick{24}
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
