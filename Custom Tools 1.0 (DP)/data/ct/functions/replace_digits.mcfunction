# Parameters: {score_holder:"<name>", objective:"<objective>", start:"<power of 10>", end:"<power of 10>", value:"<number>"}
# If Willllllliam's value score is 123456 and the below is run
# function ct:replace_digits {score_holder:"Willllllliam", objective:"value", start:"10000", end:"100", value:"88"}
# Willlllllliam's value score should be changed to 128856

$scoreboard players set $(start) constant $(start)
$scoreboard players set $(end) constant $(end)

$scoreboard players operation $(score_holder) held_value = $(score_holder) $(objective)
$scoreboard players operation $(score_holder) $(objective) /= $(start) constant
$scoreboard players operation $(score_holder) $(objective) *= $(start) constant
$scoreboard players operation $(score_holder) held_value %= $(end) constant
$scoreboard players operation $(score_holder) $(objective) += $(score_holder) held_value
$scoreboard players set $(score_holder) held_value $(value)
$scoreboard players operation $(score_holder) held_value *= $(end) constant
$scoreboard players operation $(score_holder) $(objective) += $(score_holder) held_value