t = int(input())
for i in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    c = a[0] + a[1]

    ans = False
    for i in range(2, n):
        if c <= a[i]:
            print(1, 2, i+1)
            ans = True
            break

    if not ans:
        print(-1)