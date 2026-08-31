n = int(input())
numList = []
answer = 0
for i in range(0, n):
    item = int(input())
    numList.append(item)
player1 = "Aleksei"
player2 = "Boris"
nextPlayer = "Vasilii"
playerList = [player1, player2, nextPlayer]
for i in range(0, n):
    if numList[i] == 1:
        if player1 == "Aleksei":
            (player2, nextPlayer) = (nextPlayer, player2)
        elif player2 == "Aleksei":
            (player1, nextPlayer) = (nextPlayer, player1)
        else:
            answer = "NO"
            break
    elif numList[i] == 2:
        if player1 == "Boris":
            (player2, nextPlayer) = (nextPlayer, player2)
        elif player2 == "Boris":
            (player1, nextPlayer) = (nextPlayer, player1)
        else:
            answer = "NO"
            break
    elif numList[i] == 3:
        if player1 == "Vasilii":
            (player2, nextPlayer) = (nextPlayer, player2)
        elif player2 == "Vasilii":
            (player1, nextPlayer) = (nextPlayer, player1)
        else:
            answer = "NO"
            break
if answer != "NO":
    print("YES")
else:
    print("NO")
