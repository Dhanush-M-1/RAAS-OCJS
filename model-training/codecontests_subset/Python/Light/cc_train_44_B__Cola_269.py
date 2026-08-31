n,a,b,c=map(int,input().split());r=0
if 2*c+b+a//2<n:
    print(r)
else:
    for i in range(c+1):
        k=n-2*i
        q,w=min(b,a//2,k),max(b,a//2)
        if k<=b+a//2 and k>0:
            if k<=w:r+=q+1
            else:
                if q+1-k+w>=0:r+=q+1-k+w
        elif k==0:r+=1
    print(r)