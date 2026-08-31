################om namh shivay##################37
###############(BHOLE KI FAUJ KREGI MAUJ)############37
from sys import stdin,stdout 
import math,queue,heapq
fastinput=stdin.readline
fastout=stdout.write
z=1
while z:
    z-=1 
    #n=int(fastinput()) 
    #s=input()
    n,k=map(int,fastinput().split())
    #x,y,n=map(int,fastinput().split())
    #a=[0]+list(map(int,fastinput().split()))
    #a=list(map(int,fastinput().split()))
    common=[] 
    onlyx=[] 
    onlyy=[]
    for i in range(n):
        t,x,y=map(int,fastinput().split()) 
        if x==0 and y==0:
            continue 
        else:
            if x==1 and y==1:
                common.append(t) 
            elif x==0 and y==1:
                onlyy.append(t)
            else:
                onlyx.append(t)
    #matrix=[list(map(int,fastinput().split())) for _ in range(n)] 
    
    onlyy.sort() 
    onlyx.sort() 
    if len(onlyx)>k:
        onlyx=onlyx[:k] 
    if len(onlyy)>k:
        onlyy=onlyy[:k] 
    if len(onlyy)+len(common)<k or len(onlyx)+len(common)<k:
        print(-1) 
    else:
        for i in range(min(len(onlyx),len(onlyy))):
            common.append(onlyx[i]+onlyy[i]) 
        common.sort()  
        print(sum(common[:k]))

    

    
    
    
            
    
 