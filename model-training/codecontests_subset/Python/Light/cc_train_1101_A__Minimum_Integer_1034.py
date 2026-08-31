q=int(input())
while(q):
    l,r,d=map(int,input().split())
    if(l>d or d>r):
        print(d)
    else:
        print(r//d*d+d)
    q=q-1    