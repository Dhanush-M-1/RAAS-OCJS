import sys
r1,r2=map(int,input().split())
c1,c2=map(int,input().split())
d1,d2=map(int,input().split())
for i in range(1,10):
    for j in range(1,10):
        for k in range(1,10):
            for l in range(1,10):
                if(i+j==r1 and i+k==c1 and k+l==r2 and j+l==c2 and i+l==d1 and j+k==d2):
                    set1=set([i,j,k,l])
                    if(len(set1)==4):
                        print(i,j)
                        print(k,l)
                        f=1
                        sys.exit()                    
                        
print(-1)