package enviromine.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import enviromine.core.EM_Settings;

public class EM_GuiGeneral extends GuiScreen
{
	private GuiScreen parentGuiScreen;
	
	public EM_GuiGeneral(GuiScreen par1GuiScreen)
	{
        this.parentGuiScreen = par1GuiScreen;
    }
	
	public void initGui()
	{

		this.buttonList.add(new GuiButton(150, this.width / 2 - 160, this.height / 6 + 96 - 6, 160, 20, "Physics: " +EM_Settings.enablePhysics));


		
		if (EM_Settings.useFarenheit == true)
		{
			this.buttonList.add(new GuiButton(152, this.width / 2 + 2, this.height / 6 + 96 - 6, 160, 20, "Temperature Scale: Fahrenheit"));	
		}
		else
		{
			this.buttonList.add(new GuiButton(152, this.width / 2 + 2, this.height / 6 + 96 - 6, 160, 20, "Temperature Scale: Celsius"));	
		}
		
		
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, I18n.getString("gui.back")));
   
	}
	
	public boolean doesGuiPauseGame()
	{
		return true;
	}
	
    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    public void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
        	if(par1GuiButton.id == 150)
        	{
        		System.out.println("Test");
        		EM_Settings.enablePhysics = !EM_Settings.enablePhysics;
        		
        		par1GuiButton.displayString = "Physics: " + EM_Settings.enablePhysics;
        	}
        	else if(par1GuiButton.id == 152)
        	{
        		EM_Settings.useFarenheit = !EM_Settings.useFarenheit;
        	}
        	else if (par1GuiButton.id == 200)
        	{
        		this.mc.displayGuiScreen(this.parentGuiScreen);
        	}
        }
    }

    
    public void drawScreen(int par1, int par2, float par3)
    {
    	this.drawDefaultBackground();
    	this.drawCenteredString(this.fontRenderer,"Enviromine Config Settings", this.width / 2, 15, 16777215);
    	super.drawScreen(par1, par2, par3);
    }
}
