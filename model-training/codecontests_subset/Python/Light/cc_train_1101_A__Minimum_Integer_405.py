q=int(input())
for i in range(q):
    l,r,d=map(int,input().split())
    if l%d==0:
        a=(l//d)-1
    else:
        a=l//d
    b=(r//d)+1
    if a==0:
        print(b*d)
    else:
        print(d)
              
