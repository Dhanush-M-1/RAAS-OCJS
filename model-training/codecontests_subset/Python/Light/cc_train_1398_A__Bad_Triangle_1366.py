from sys import*
input= stdin.readline
t=int(input())
for _ in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    c=0
    a=l[0]+l[1]
    b=l[-1]
    if(a<=b):
        print(1,2,n)
    else:
        print(-1)
    
    
        