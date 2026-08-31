t=int(input())
for _ in range(t):
    n=int(input())
    l=list(map(int,input().split()))
    f=0
    if n>2:
        if n%2==0:
            for i in range(n//2):
                if i!=n//2 -1:
                
                    if l[i]<i or l[n-i-1]<i:
                        f=1
                        break
                else:
                    k=max(l[i],l[n-1-i])
                    k1=min(l[i],l[n-i-1])
                    m1=min(i,n-i-1)
                    m=max(i,n-i-1)
                    if k<m or k1<m1:
                        f=1
                        break
        else:
            if l[n//2]>=n//2:
                
                for i in range(n//2):
                    if l[i]<i or l[n-i-1]<i:
                        f=1
                        break
            else:
                f=1
    else:
        if n==2:
            if l[0]==0 and l[1]==0:
                f=1
    if f==0:
        print('Yes')
    else:
        print('No')
                
                    