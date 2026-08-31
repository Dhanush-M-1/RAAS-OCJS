################om namh shivay##################37
###############(BHOLE KI FAUJ KREGI MAUJ)############37
from sys import stdin,stdout 
import math,queue,heapq
fastinput=stdin.readline
fastout=stdout.write
t=int(fastinput())
while t:
    t-=1 
    n=int(fastinput()) 
    #n,m=map(int,fastinput().split())
    #x,y,n=map(int,fastinput().split())
    #a=[0]+list(map(int,fastinput().split()))
    #a=list(map(int,fastinput().split()))
    #b=list(map(int,fastinput().split()))
    #matrix=[list(map(int,fastinput().split())) for _ in range(n)] 
    if n==1:
        print(0) 
    else:
        cpunt6=0 
        count3=0 
        while n%6==0 :
            n//=6 
            cpunt6+=1  
        while n%3==0:
            n//=3 
            count3+=1  
        if n!=1:
            print(-1) 
        else:
            print(cpunt6+count3*2)
            
    
 