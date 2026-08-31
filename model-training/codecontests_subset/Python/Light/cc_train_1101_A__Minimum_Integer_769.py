q=int(input())
for i in range(q):
    l,r,d=map(int,input().split())
    if d >=l and d<=r:
        print(((r//d)+1)*d)
    else:
        print(d)