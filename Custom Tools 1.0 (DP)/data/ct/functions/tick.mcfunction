schedule function ct:tick 1t

execute as @e[type=item, name="Stick"] at @s if block ~ ~-1 ~ crafting_table if entity @a[distance=..5] run function ct:craft_stick

execute as @e[type=item, name="Wooden Axe", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_wooden_heads
execute as @e[type=item, name="Wooden Hoe", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_wooden_heads
execute as @e[type=item, name="Wooden Pickaxe", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_wooden_heads
execute as @e[type=item, name="Wooden Shovel", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_wooden_heads
execute as @e[type=item, name="Wooden Sword", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_wooden_heads
execute as @e[type=item, name="Stone Axe", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_stone_heads
execute as @e[type=item, name="Stone Hoe", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_stone_heads
execute as @e[type=item, name="Stone Pickaxe", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_stone_heads
execute as @e[type=item, name="Stone Shovel", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_stone_heads
execute as @e[type=item, name="Stone Sword", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_stone_heads
execute as @e[type=item, name="Iron Axe", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_iron_heads
execute as @e[type=item, name="Iron Hoe", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_iron_heads
execute as @e[type=item, name="Iron Pickaxe", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_iron_heads
execute as @e[type=item, name="Iron Shovel", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_iron_heads
execute as @e[type=item, name="Iron Sword", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_iron_heads
execute as @e[type=item, name="Diamond Axe", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_diamond_heads
execute as @e[type=item, name="Diamond Hoe", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_diamond_heads
execute as @e[type=item, name="Diamond Pickaxe", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_diamond_heads
execute as @e[type=item, name="Diamond Shovel", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_diamond_heads
execute as @e[type=item, name="Diamond Sword", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_diamond_heads
execute as @e[type=item, name="Netherite Axe", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_netherite_heads
execute as @e[type=item, name="Netherite Hoe", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_netherite_heads
execute as @e[type=item, name="Netherite Pickaxe", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_netherite_heads
execute as @e[type=item, name="Netherite Shovel", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_netherite_heads
execute as @e[type=item, name="Netherite Sword", tag=!just_reheaded] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_netherite_heads

execute as @e[type=item, name="Wooden Axe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Wooden Hoe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Wooden Pickaxe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Wooden Shovel", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Wooden Sword", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Stone Axe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Stone Hoe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Stone Pickaxe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Stone Shovel", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Stone Sword", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Iron Axe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Iron Hoe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Iron Pickaxe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Iron Shovel", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Iron Sword", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Golden Axe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Golden Hoe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Golden Pickaxe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Golden Shovel", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Golden Sword", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Diamond Axe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Diamond Hoe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Diamond Pickaxe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Diamond Shovel", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Diamond Sword", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Netherite Axe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Netherite Hoe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Netherite Pickaxe", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Netherite Shovel", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles
execute as @e[type=item, name="Netherite Sword", tag=!just_rehandled] at @s if block ~ ~-1 ~ minecraft:crafting_table if entity @a[distance=..5] run function ct:check_handles

execute as @e[type=item, name="Wooden Axe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Wooden Hoe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Wooden Pickaxe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Wooden Shovel", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Wooden Sword", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Stone Axe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Stone Hoe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Stone Pickaxe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Stone Shovel", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Stone Sword", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Iron Axe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Iron Hoe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Iron Pickaxe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Iron Shovel", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Iron Sword", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Golden Axe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Golden Hoe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Golden Pickaxe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Golden Shovel", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Golden Sword", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Diamond Axe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Diamond Hoe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Diamond Pickaxe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Diamond Shovel", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Diamond Sword", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Netherite Axe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Netherite Hoe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Netherite Pickaxe", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Netherite Shovel", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims
execute as @e[type=item, name="Netherite Sword", tag=!just_retrimmed] at @s if block ~ ~-1 ~ minecraft:smithing_table if entity @a[distance=..5] run function ct:check_trims

scoreboard players enable @a cthelp
execute as @a[scores={cthelp=1}] run function ct:help/cthelp
scoreboard players enable @a ctsticks
execute as @a[scores={ctsticks=1}] run function ct:help/ctsticks
scoreboard players enable @a ctheads
execute as @a[scores={ctheads=1}] run function ct:help/ctheads
scoreboard players enable @a ctwoodenheads
execute as @a[scores={ctwoodenheads=1}] run function ct:help/ctwoodenheads
scoreboard players enable @a ctstoneheads
execute as @a[scores={ctstoneheads=1}] run function ct:help/ctstoneheads
scoreboard players enable @a ctironheads
execute as @a[scores={ctironheads=1}] run function ct:help/ctironheads
scoreboard players enable @a ctdiamondheads
execute as @a[scores={ctdiamondheads=1}] run function ct:help/ctdiamondheads
scoreboard players enable @a ctnetheriteheads
execute as @a[scores={ctnetheriteheads=1}] run function ct:help/ctnetheriteheads
scoreboard players enable @a cthandles
execute as @a[scores={cthandles=1}] run function ct:help/cthandles
scoreboard players enable @a cttrims
execute as @a[scores={cttrims=1}] run function ct:help/cttrims
scoreboard players enable @a ctexample
execute as @a[scores={ctexample=1}] run function ct:help/ctexample
scoreboard players enable @a ctsteps
execute as @a[scores={ctsteps=1}] run function ct:help/ctsteps