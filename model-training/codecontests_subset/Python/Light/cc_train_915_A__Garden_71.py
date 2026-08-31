a, b = map(int, input().split())
x = sorted(list(map(int, input().split())))
for i in range(len(x)-1, -1, -1):
    if b % x[i] == 0:
        print(b // x[i])
        exit()