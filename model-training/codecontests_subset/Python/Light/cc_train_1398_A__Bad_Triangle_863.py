t = int(input())
for _ in range(t):
    n = int(input())
    ali = list(map(int, input().split()))
    q = ali[1] + ali[0]
    if(ali[-1] >= q):
        print(1, 2, n)
    else:
        print(-1)