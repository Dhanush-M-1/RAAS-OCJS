import sys
import math
input=sys.stdin.readline

n,p,w,d=map(int,input().split())
wins=-1
draw=-1
flag=0
for i in range(w+1):
    curr=i*d
    
    if((p-curr)%w==0 and (p-curr)//w<=(n-i)):
        draw=i
        wins=(p-curr)//w
        break
    elif((p-curr)//w>(n-i)):
        print(-1)
        flag=1
        break
if(flag!=1 ):
    if(wins>=0 and draw>=0):
        print(wins,draw,n-wins-draw)
    else:
        print(-1)
        

        
    

            
    
    
            

    
    
        
    
    
