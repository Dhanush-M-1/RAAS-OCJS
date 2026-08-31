import sys
input=sys.stdin.readline

def cost(a,b):
    rdiff=b[0]-a[0]
    cdiff=b[1]-a[1]

    if (a[0]+a[1])%2==0:
        if rdiff==cdiff:
            return rdiff
        if rdiff==cdiff+1:
            return 0
        if rdiff%2==0:
            return rdiff//2 -(cdiff+1)//2
        if rdiff%2==1:
            return rdiff//2 -cdiff//2
    if (a[0]+a[1])%2==1:
        if rdiff==cdiff:
            return 0
        if rdiff==cdiff+1 or rdiff==cdiff+2:
            return 1
        if rdiff%2==0:
            return (rdiff+1)//2 - cdiff//2
        if rdiff%2==1:
            return (rdiff+1)//2 - (cdiff+1)//2


t = int(input())
 
for i in range(t):
    n=int(input())
    r=[int(x) for x in input().split()]
    c=[int(x) for x in input().split()]

    points=sorted(zip(r,c))

    ans=cost((1,1),points[0])
    
    for i in range(n-1):
        ans+=cost(points[i],points[i+1])
    
    print(ans)