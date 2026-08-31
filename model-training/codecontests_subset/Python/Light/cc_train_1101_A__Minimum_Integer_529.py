q=int(input())
while q:
    l,r,d=map(int,input().split())
    if(d<l):
        print(d)
    elif(d>r):
        print(d)
    else:
        a=r//d
        print((a+1)*d)
    q-=1    