# Custom Tools
See the Modrinth page (Coming soon) for a complete description of how to use the data pack, this README covers how to use the helper script to modify this datapack and add your own custom textures.

### Running CustomToolsHelper
To run CustomToolsHelper, you will need ``CustomToolsHelper.class``, which you can downoad from here or compile yourself from ``CustomToolsHelper.java``, also found here.
You will also need a settings file, the default is ``CustomToolsSettings.txt``, which you can download here.
If you download ``CustomToolsSettings.txt``, you will need to replace a couple lines with the paths to the data pack and the resource pack (See below for specifics)
To run the script, open a command line in the folder/directory where both the script and settings files are and run ``java CustomToolsHelper CustomToolsSettings.txt``, replacing ``CustomToolsSettings.txt`` if you have a different settings file.

### CustomToolsSettings format:
The CustomToolsSettings file is organized into sections, each beginning with a header and usually ending with an ``END`` line. The order of these sections does not matter, as long as they are all there. I would reccommend looking at CustomToolsSettings.txt as you read this, just to see an example of what is being talked about.

#### ``DATAPACK_PATH`` and ``RESOURCE_PACK_PATH``
These are the only sections you need to modify if you are using the default settings (which I'm not sure why you'd do that because you can just download the defualt settings here or on Modrinth). These are both only one line, so they don't need an ``END`` line. ``DATAPACK_PATH`` contains, as the placeholder suggests, a file path to the root folder of the datapack. This is where the script will write datapack files to. ``RESOURCE_PACK_PATH`` is the same, but the path to the resource pack instead.

#### ``TOOL_MATERIALS`` and ``TOOL_TYPES``
You probably shouldn't change either of these. ``TOOL_MATERIALS`` contains a list of the vanilla tool materials and ``TOOL_TYPES`` lists the vanilla tool types, both as they appear in the item's display name (not the namespace ID). The only reason I can think of for changing it would be if you are using a mod that adds more tools and you want to customize those too.

#### ``HEAD_MATERIALS``
Finally something interesting! ``HEAD_MATERIALS`` contains all the head materials, IDs, and crafting components for the custom tools. They are written in the format ``<material_name>:<Double Digit ID>:[<Crafting Component>]``, for example, ``oak:01:Oak Planks``. The format is split into three parts, separated by colons (``:``). The first part is the material name, written as it appears in the texture files and will appear in the model files (snake_case is reccomended). The second part is the numeric ID, used to compute the CustomModelData the item will use (which is, for those curious, ``1<Head ID><Handle ID><Trim ID>``). The ID must be 2 digits, so ``00``-``99`` are valid. The third part is the crafting component, which is optional. If it is not included, the head material can't be crafted. The crafting component is written as it appears in the item's display name.

The head material is different from the trim or handle materials in that it depends on the vanilla material of the tool. Each vanilla material has its own set of IDs. The vanilla materials must be listed first with the ID ``00``, in the order they are written in ``TOOL_MATERIALS`` (but still snake_case). The script assumes the first custom material in the list is for the first vanilla material, and then keeps that assumption until it hits another ID ``00``, at which point it switches to the next vanilla material, and so on.

#### ``HANDLE_MATERIALS``
``HANDLE_MATERIALS`` is quite similar to ``HEAD_MATERIALS``, except it doesn't depend on the vanilla tool, so it's simply one of each ID. It uses the same three part format as the head, with the addition of a syntax for requiring a specific custom model data on the crafting component: ``<Crafting Component>[{CustomModelData ID}]``. For example, ``Stick{1}``. This allows the use of custom sticks to craft custom handles. ID 00 should be used for the default stick.

#### ``TRIM_MATERIALS``
``TRIM_MATERIALS`` is the same as ``HANDLE_MATERIALS``, but it doesn't allow custom model data on crafting components. ID 00 is automatically added as no trim.

#### ``STICKS``
``STICKS`` is once again similar to the others. It doesn't allow custom model data on crafting components, and the unique thing about it is that it doesn't need double digit IDs.
