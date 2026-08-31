for t in range(int(input())):
    play, clear = [], []
    for i in range(int(input())):
        p, c = map(int, input().split())
        play.append(p)
        clear.append(c)
    play.insert(0, -1)
    clear.insert(0, -1)
    for i in range(1, len(play)):
        if(play[i] >= clear[i]):
            if(play[i] >= play[i - 1] and clear[i] >= clear[i - 1]):
                a, b = play[i] - play[i - 1], clear[i] - clear[i - 1]
                if(b > a):
                    print('NO')
                    break

                elif(i == (len(play) - 1)):
                    print('YES')

            else:
                print('NO')
                break

        else:
            print('NO')
            break
