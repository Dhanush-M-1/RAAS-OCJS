for _ in range(int(input())):
    n = int(input())
    flag = 1
    for i in range(n):
        if i == 0:
            play, win = map(int, input().split())
            if win > play:
                flag = 0
        else:
            t1, t2 = map(int, input().split())
            if flag:
                if t2 <= t1 and t2 - win >= 0:
                    d = t2 - win
                    if t1 - play < d:
                        flag = 0
                    play = t1
                    win = t2
                else:
                    flag = 0

    if flag == 0:
        print('NO')
    else:
        print('YES')