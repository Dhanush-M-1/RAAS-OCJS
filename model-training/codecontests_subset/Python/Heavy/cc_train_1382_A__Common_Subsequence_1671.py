import math
def dtb(n): 
    return bin(n).replace("0b","")
def btd(n): 
    return int(n,2) 
t=int(input())
for k in range(t):
    n,m=map(int,input().split())
    a=list(map(int,input().split()))[:n]
    b=list(map(int,input().split()))[:m]
    c=0
    f=0
    
    
    for i in range(n):
        for j in range(m):
            if a[i]==b[j]:
                c=a[i]
                f=1
                break
           
    if f==1:
        print("YES") 
        print(1,c)
    else :
        print("NO")
            
        
    