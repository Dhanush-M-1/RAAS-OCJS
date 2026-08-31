t=int(input())
while(t):
    t-=1
    a,b,d=map(int,input().split())
    if(a>d):
        print(d)
    else:
        print(b+d-b%d)