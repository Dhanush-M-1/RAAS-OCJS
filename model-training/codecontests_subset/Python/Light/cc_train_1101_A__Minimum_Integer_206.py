import math
q=int(input())
#q=1
for _ in range(q):
    l,r,d=map(int,input().split())
    n=l/d 
    m=r/d 
    if n>1:
        print(d)
    else:
        if (math.ceil(m))==m:
            print(int((m+1)*d))
        else:    
            print(d*(math.ceil(m)))
    
    