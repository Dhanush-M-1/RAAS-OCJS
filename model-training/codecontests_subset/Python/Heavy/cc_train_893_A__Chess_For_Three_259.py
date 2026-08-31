def main():
    n = int(input())
    winners = [0] * n

    for i in range(n):
        winners[i] = int(input())

    player1 = 1
    player2 = 2
    spectator = 3

    i = 0
    wrong_log = False

    while i < n and not wrong_log:
        if winners[i] == player1:
            tmp = player2
            player2 = spectator
            spectator = tmp
            i += 1
        elif winners[i] == player2:
            tmp = player1
            player1 = spectator
            spectator = tmp
            i += 1
        else:
            wrong_log = True

    print('NO' if wrong_log else 'YES')


if __name__ == '__main__':
    main()
