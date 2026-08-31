q = int(input())
for I in range(q):
    l, r, d = map(int,input().split())
    l1,r1 = min(l,r),max(l,r)
    if d < l1: print(d)
    else: print((r1//d+1)*d)