import math
def dtb(n): 
    return bin(n).replace("0b","")
def btd(n): 
    return int(n,2) 
t=int(input())
for k in range(t):
    n=int(input())
    a=list(map(int,input().split()))[:n]
    x,z=0,n-1
    flag=0
    for i in range(1,n-1):
        if(a[i]+a[x]<=a[z] or a[i]+a[z]<=a[x] or a[x]+a[z]<=a[i]):
            print(x+1,i+1,z+1)
            flag=1
            break
    if flag==0:
        print(-1)
            
        
    