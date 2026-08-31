t = int(input())
for _ in range(t):
    l, r, d = map(int, input().split())
    if d < l:
        print(d)
    else:
        print(r-(r%d)+d)