##chess for tree
##893A


def getnewplayer(lst):
    for i in range(1,4):
        if i not in lst:
            return i
    




    



result = "YES"
n = int(input()) ##number of games played
winners = []
for i in range(n):
    winner = int(input())
    winners.append(winner)
players = (1,2)
for i in range(0, n):
    if winners[i] not in players:
        result = "NO"
        break
    else:
        newplayer = getnewplayer(players)
        players = (winners[i], newplayer)

        

print(result)
