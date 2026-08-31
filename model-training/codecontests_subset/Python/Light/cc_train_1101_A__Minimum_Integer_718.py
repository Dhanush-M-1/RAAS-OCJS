q = int(input())
for i in range(q):
    l, r, d = map(int, input().split())
    if d > 0 and d < l:
        print(d)
    else:
        print(((r+d)//d) * d)
