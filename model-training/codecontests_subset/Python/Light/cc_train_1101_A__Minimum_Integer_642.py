q = int(input())
for _ in range(q):
    l,r,d = map(int, input().split())
    if l <=d: print((r//d+1)*d)
    else: print(d)