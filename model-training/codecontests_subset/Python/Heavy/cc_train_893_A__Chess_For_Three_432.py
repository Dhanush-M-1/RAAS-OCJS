




def main():
    n = int(input().strip())

    games = list()

    Player1 = 1
    Player2 = 2
    Spectator = 3

    for i in range(0, n):
        games.append(int(input().strip()))

    for i in range(0, n):
        Winner = games[i]
        if(Winner != Player1 and Winner != Player2):
            print("NO")
            return
        else:
            if Winner == Player1:
                temp = Player2
                Player2 = Spectator
                Spectator = temp
            elif Winner == Player2:
                temp = Player1
                Player1 = Spectator
                Spectator = temp
    print("YES")

if __name__ == "__main__":
    main()
