#1101A
q = int(input())
for u in range(q):
    [l,r,d] = list(map(int,input().split()))
    if d < l:
        print(d)
    else:
        print(((r//d)+1)*d)