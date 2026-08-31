def main():
    n = int(input())
    game_log = []
    for _ in range(0, n):
        game_log.append(int(input()))

    # Carl cannot win first
    if game_log[0] == 3:
        print("NO")
        return

    # Array for current players
    playing = [True, True, False]
    for game in game_log:
        if not playing[game - 1]:
            print("NO")
            return
        playing[game - 1] = False
        playing = [not x for x in playing]

    print ("YES")

if __name__ == '__main__':
    main()
