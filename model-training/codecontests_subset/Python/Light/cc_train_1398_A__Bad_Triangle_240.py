t = int(input())

for _ in range(t):
    n = int(input())
    v = [int(x) for x in input().split()]
    if v[0] + v[1] <= v[-1]:
        print(1,2,n)
    else:
        print(-1)
