q = int(input())
for _ in range(q):
    l,r, d = map(int, input().split())
    if (l-1)//d >= 1:
        print(d)
    else:
        if r%d != 0:
            print(d*((r+d-1)//d))
        else:
            print(d*(r//d+1))
