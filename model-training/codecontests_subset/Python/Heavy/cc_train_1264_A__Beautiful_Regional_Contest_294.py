'''input
5
12
5 4 4 3 2 2 1 1 1 1 1 1
4
4 3 2 1
1
1000000
20
20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1
32
64 64 63 58 58 58 58 58 37 37 37 37 34 34 28 28 28 28 28 28 24 24 19 17 17 17 17 16 16 16 16 11
'''
from sys import stdin
def input():
    return stdin.readline()[:-1]


for _ in range(int(input())):
    n = int(input())
    v = list(map(int, input().split()))
    splits = []

    if n < 8:
        print('0 0 0')
    else:
        a, b = 0, n
        for i in range(1, b):
            if v[i] < v[i - 1]:
                splits.append(i)

        if len(splits) < 3:
            print('0 0 0')
        else:
            g = splits[0]
            s = -1
            for i in range(1,len(splits)):
                if splits[i] - g > g:
                    s = splits[i]
                    si = i
                    break
            if s == -1:
                print('0 0 0')
            else:
                ib = si + 1
                b = -1
                while ib < len(splits):
                    if splits[ib] - s > g and splits[ib] <= n // 2:
                        b = splits[ib]
                    ib += 1

                print(g, s - g, b - s) if b != -1 else print('0 0 0')


