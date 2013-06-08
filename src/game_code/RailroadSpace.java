package game_code;

public class RailroadSpace extends AbstractSpace{
	private String railroadName;
	private Player railroadOwner;
	
	public RailroadSpace(String railroadName) {
		this.railroadName = railroadName;
		this.railroadOwner = null;
	}
	
	public String getRailroadName() {return this.railroadName;}
	
	public Player getRailroadOwner() {return this.railroadOwner;}
	
	@Override
	public void interactWithLandAction(Player player) {
		if (isThisRailroadOwned()) {
			chargePlayerRent(player);
		} else {
			if(player.getMyMoney() >= 200) {
				this.buyThisRailroad(player);
			}
		}
	}
	
	private boolean isThisRailroadOwned() {
		if (railroadOwner == null) return false;
		else return true;
	}
	
	private void chargePlayerRent(Player player) {
		player.changeMyMoney(-50);
		railroadOwner.changeMyMoney(50);
	}	

	private void buyThisRailroad(Player player) {
		player.changeMyMoney(-200);
		railroadOwner = player;
	}
}
