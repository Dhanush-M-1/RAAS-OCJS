Q = int(input())
for i in range(Q):
    l, r, d = map(int, input().split())
    if l > d:
        print(d)
    else:
        n = r//d
        print((n+1)*d)