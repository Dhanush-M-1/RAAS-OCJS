from collections import defaultdict,deque
import sys
import bisect
import math
input=sys.stdin.readline
mod=1000000007

t=int(input())
for i in range(t):
    l=[i for i in input() if i!='\n']
    if len(l)==1:
        print(0)
    else:
        ans,i=0,0
        while i <len(l):
            if i+1<len(l) and l[i]==l[i+1] and l[i]!='0':
                l[i+1]='0'
                ans+=1
            if i+2<len(l) and l[i]==l[i+2] and l[i]!='0':
                l[i+2]='0'
                ans+=1
            i+=1
        print(ans)
           
                


    
    

           
                


    
    

           
                


    
    
       
            


    
    
        
    
