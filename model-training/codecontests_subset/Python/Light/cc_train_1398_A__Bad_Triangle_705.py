t = int(input())
for _ in range(t):
    n = int(input())
    vals = [int(x) for x in input().split()]
    if vals[0] + vals[1] <= vals[-1]:
        print(1, 2, n)
    else:
        print(-1)