package ihm.console

import system.attr.AttrComponent

class TestConsole {

    fun start(){
        var attrComponent = AttrComponent(hp = 100)
        println("A ${attrComponent.hp} HP");

        // Ecouter changement
        attrComponent.listenHPChange(_onHPChange = {
            println("Les pv sont à ${attrComponent.hp} HP");
        })

        // je fais perdre 30 pv
        attrComponent.looseHP(30)

        attrComponent.looseHP(10)

        attrComponent.looseHP(5)

        // je fais perdre 200 pv
        attrComponent.looseHP(200)
    }
}