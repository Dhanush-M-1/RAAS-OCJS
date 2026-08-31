q = int(input())
for k in range(q):
    l, r, d = map(int, input().split())
    if d < l:
        print(d)
    else:
        print(r + d - r%d)