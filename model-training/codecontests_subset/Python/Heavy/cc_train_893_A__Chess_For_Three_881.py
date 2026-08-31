players = {
    1: 'Alex',
    2: 'Bob',
    3: 'Carl'
}

player_one, player_two, spectator, logs, i = players[1], players[2], players[3], [
], 0

n = int(input())

if n < 1 or n > 100:
    raise Exception()


while i < n:
    winner = int(input())
    if winner < 1 or winner > 3:
        raise Exception()

    logs.append(winner)
    i += 1

while len(logs):
    winner = logs.pop(len(logs) - len(logs))
    winner_player = players[winner]
    # If winner_player is not player_one or player_two then spectator can't even win
    if winner_player != player_one and winner_player != player_two:
        print('NO')
        break
    # Finding out who is the winner among player_one and player_two
    # Finding out who is the loser among player_one and player_two
    winner_player, loser_player = player_one if winner_player == player_one else player_two, player_one if winner_player != player_one else player_two
    player_one, player_two, spectator = winner_player, spectator, loser_player
    i -= 1

if i == 0:
    print('YES')

    	  		 	 		      							  	