x=int(input())
for i in range(0,x):
    n=int(input())
    m=list(map(int,input().split()))[:n]
    if(m[0]+m[1]>m[-1]):
        print(-1)
    else:
        print(1,2,n)
        
                