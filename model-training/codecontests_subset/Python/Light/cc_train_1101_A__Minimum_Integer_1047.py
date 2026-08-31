Q = int(input())
for q in range(Q):
    l, r, d = map(int, input().split())
    if d < l or d > r:
        print(d)
    else:
        x = r//d
        print((x+1)*d)
