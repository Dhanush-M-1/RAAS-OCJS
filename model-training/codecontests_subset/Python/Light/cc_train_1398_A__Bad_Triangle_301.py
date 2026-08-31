t = int(input())
for i in range(t):
    n = int(input())
    s = input().split()
    a = list(map(int, s))

    if a[0] + a[1] > a[len(a)-1]:
        print(-1)
    else:
        print(1, 2, len(a))
