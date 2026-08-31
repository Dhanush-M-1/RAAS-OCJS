import sys
# from collections import defaultdict
t=1
t=int(input())
for i in range(t):
    n=int(input())
    # x,y,n=list(map(int,sys.stdin.readline().strip().split()))
    # a,b,c,d=list(sys.stdin.readline().strip().split())
    # n,k=list(map(int,sys.stdin.readline().strip().split()))
    
    # a=(n//x)*x+y
    # b=((n//x)-1)*x+y
    
    # if(a<=n):
    #     print(a)
    # else:
    #     print(b)
    
    f=1
    a=0
    while(n%3==0):
        n=n//3
        a+=1
    b=0
    while(n%2==0):
        n=n//2
        b+=1
    # print(a,b,n)
    if(n==1):
        f=0
    
    if(f):
        print(-1)
    elif(b>a):
        print(-1)
    else:
        print(a+a-b)