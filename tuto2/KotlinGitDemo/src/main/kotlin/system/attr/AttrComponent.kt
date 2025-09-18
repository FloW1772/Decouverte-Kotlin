package system.attr

class AttrComponent(var hp: Int) {

    var onHPChange : () -> Unit = {};

    fun listenHPChange(_onHPChange : () -> Unit){
        onHPChange = _onHPChange
    }

    /**
     * Perdre des vie notifie avec un callback de la classe si notify = true
     */
    fun looseHP(amount: Int, notify: Boolean = true) : Boolean {
        hp -= amount;
        if (hp < 0 ) {
            hp = 0;
        }

        // Forcer les vie a 0 si 1hp
        if(hp==1) {
            hp = 0; // parce qu'un jeu c'est pas toujours juste
        }

        // Notifier si les vie change
        if (notify){
            onHPChange();
        }
        return true;
    }

    fun gainHp(amount: Int) : Boolean {
        hp += amount;
        return true;
    }

    /**
     * Récupérer le pourcentage de vie restant
     * TODO : Definir un maxHp
     */
    fun getHPPercent() : Float {
        return hp/100.0f;
    }
}