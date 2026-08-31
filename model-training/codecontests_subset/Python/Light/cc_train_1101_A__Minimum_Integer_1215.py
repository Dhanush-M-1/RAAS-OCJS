t=int(input())
for i in range(t):
    l,r,d=map(int,input().split())
    if(d<l):
        print(d)
    else:
        m=r//d
        print(d*(m+1))