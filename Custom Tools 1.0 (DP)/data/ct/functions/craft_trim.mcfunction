tag @s add just_retrimmed

$execute store result score @s value run data get entity @e[type=item, tag=!just_retrimmed, name="$(item)", distance=..0.5, limit=1, sort=nearest] Item.Count
scoreboard players operation @s value -= 1 constant
$execute store result entity @e[type=item, tag=!just_retrimmed, name="$(item)", distance=..0.5, limit=1, sort=nearest] Item.Count byte 1 run scoreboard players get @s value

execute store result score @s value run data get entity @s Item.tag.CustomModelData
scoreboard players operation @s value > 1000000 constant
$function ct:replace_digits {score_holder:"@s", objective:"value", start:"100", end:"1", value:"$(trim_id)"}
execute store result entity @s Item.tag.CustomModelData int 1 run scoreboard players get @s value