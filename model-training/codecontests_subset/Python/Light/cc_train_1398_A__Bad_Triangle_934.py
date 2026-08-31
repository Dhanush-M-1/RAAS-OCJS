import sys
#input=sys.stdin.buffer.readline

t=int(input())
while t:
    t-=1
    n=int(input())
    a=list(map(int,input().split()))
    k=a[0]+a[1]
    c=0
    for i in range(2,n):
        if a[i]>=k:
            c=1
            break
    
    if c==1:
        print(1,2,i+1)
    else:
        print(-1)
    