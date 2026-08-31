import math
from collections import defaultdict
ml=lambda:map(int,input().split())
ll=lambda:list(map(int,input().split()))
ii=lambda:int(input())
ip=lambda:list(input())

"""========main code==============="""

t=1
#t=ii()
for _ in range(t):
    a,b=ml()
    c,d=ml()
    e,f=ml()
    
    flag=0
    ans=[]
    for i in range(1,10):
        for j in range(1,10):
            for k in range(1,10):
                for l in range(1,10):
                    if((i+k==c and i!=k) and (j+l==d and j!=l) and (i+j==a and i!=j) and (k+l==b and k!=l) and (i+l==e and i!=l) and (j+k==f and j!=k) ):
                        flag=1
                        ans=[[i,j],[k,l]]
                        break
    if(flag):
        for i in ans:
            print(*i)
    else:
        print(-1)
 	   		 	     		  		  	  	  	 	