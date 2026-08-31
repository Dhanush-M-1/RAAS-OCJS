t = int(input())
for kk in range(t):
    l, r, d = map(int, input().split())
    if l > d or r < d:
        print(d)
    else:
        print(int((r+d)/d)*d)
