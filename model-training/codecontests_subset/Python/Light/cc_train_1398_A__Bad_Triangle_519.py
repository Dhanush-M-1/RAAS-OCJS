t = int(input())
for _ in range(t):
    q = int(input())
    l = list(map(int, input().split()))
    if l[0]+l[1] > l[-1]:
        print(-1)
    else:
        print(1, 2, q)