from bisect import *
import math
a=int(input())
for i in range(a):
    n,m=map(int,input().split())
    z=list(map(int,input().split()))
    x=list(map(int,input().split()))
    for i in range(1,len(z)):
        z[i]+=z[i-1]
    maxa=[]
    for i in range(len(z)):
        if(i==0):
            maxa.append(z[0])
        else:
            maxa.append(max(maxa[-1],z[i]))
    
    for i in range(len(x)):
        r=bisect_left(maxa,x[i])
        
        if(r==len(maxa) and z[-1]<=0):
            print(-1,end=" ")
        else:
            if(r<len(maxa)):
                print(r,end=" ")
            else:

                
                left=x[i]-maxa[-1]
                rounds=math.ceil(left/z[-1])
                actual=x[i]-(rounds*z[-1])
                r=bisect_left(maxa,actual)
                total=rounds*(len(z))-1
                print(total+r+1,end=" ")
                
            
                
             
                        
                    
    print(' ')
                
        
