t=int(input())
for i in range(t):
    n=int(input())
    le=0
    l,r=map(int,input().split())
    for i in range(n-1):
        a,b=map(int,input().split())
        if le==0:
            if a<l and r<b:
                0
            elif a<l and b<l:
                l,r,le=b,l,l-b
            elif a<l and l<=b<=r:
                r=b
            elif l<=a<=b<=r:
                l,r=a,b
            elif l<=a<=r:
                l=a
            else:
                l,r,le=r,a,a-r
        else:
            if a<l and r<b:
                0
            elif a<l and b<l:
                l,le=b,r-b
            elif a<l and l<=b<=r:
                0
            elif l<=a<=b<=r:
                0
            elif l<=a<=r:
                0
            else:
                r,le=a,a-l            
    print(le)