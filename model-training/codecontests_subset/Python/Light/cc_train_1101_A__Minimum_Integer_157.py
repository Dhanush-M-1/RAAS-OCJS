T = int(input())
for _ in range(T):
    l, r, d = (int(i) for i in input().split())
    if d < l:
        print(d)
    else:
        print(d*((r//d)+1))
