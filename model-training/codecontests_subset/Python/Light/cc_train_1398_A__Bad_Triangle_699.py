t=int(input())
for _ in range(t):
    n=int(input())
    ls=list(map(int,input().split()))
    s=ls[0]+ls[1]
    if ls[-1]<s:
        print(-1)
    
    else:
        print('{} {} {}'.format(1,2,n))