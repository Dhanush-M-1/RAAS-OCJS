q = int(input())
for _ in range(q):
    l, r, d = map(int, input().split())
    if (d<l or d>r):
        print(d)
    else:
        Q = r//d
        R = r%d
        print(d*(Q+1))