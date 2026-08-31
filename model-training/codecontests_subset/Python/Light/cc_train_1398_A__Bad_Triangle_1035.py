for i in range(int(input())):
    n = int(input())
    m = list(map(int, input().split()))
    if n < 3: rez = (-1)
    elif m[0]+m[1] > m[-1]: rez = (-1)
    else: rez = 1, 2, len(m)
    if rez == -1: print(rez)
    else: print(*rez)
