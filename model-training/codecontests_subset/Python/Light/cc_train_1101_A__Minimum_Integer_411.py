import math
t=int(input())
for i in range(t):
    l,r,d = map(int, input().strip().split(' '))
    k=d

    while(True):
        
        if k%d==0 and (k<l or k>r):
            print(k)
            break
        else:
            j=r-(k)
            m=math.ceil(j/d)
            k=(m+1)*d
        if k==r:
            print(k+d)
            break
            
            
    


    
    