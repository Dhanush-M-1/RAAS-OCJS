t=int(input())
for it in range(t):
    n=int(input())
    co=True
    first=list(map(int,input().split()))
    p=first[0]
    c=first[1]
    if c>p:
        co=False
    for i in range(n-1):
        l=list(map(int,input().split()))
        if(l[0]<l[1]):
            co=False
        if(l[0]<p):
            co=False
        if(l[1]<c):
            co=False
        if((l[0]-p)<(l[1]-c)):
            co=False
        p=l[0]
        c=l[1]
    if co:
        print("YES")
    else:
        print("NO")
            