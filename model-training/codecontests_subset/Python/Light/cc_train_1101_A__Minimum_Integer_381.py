def Spider ():
    a, b, c = map(int, input().split())
    if c < a or c > b: print(c)
    else: print((int(b / c) + 1) * c)
TIMES = 1
TIMES = int(input())
for TIME_TEMP in range(TIMES):
    Spider()