#python3
#utf-8

def check(game_idx___winner, player1, player2):
    for winner in game_idx___winner:
        watcher = 6 - player1 - player2
        if winner == watcher:
            return False
        if player1 != winner:
            player1 = watcher
        if player2 != winner:
            player2 = watcher
    return True

games_nr = int(input())
game_idx___winner = [int(input()) for x in range(games_nr)]
player1 = 1
player2 = 2
if check(game_idx___winner, player1, player2):
    print('YES')
    quit()
print('NO')
