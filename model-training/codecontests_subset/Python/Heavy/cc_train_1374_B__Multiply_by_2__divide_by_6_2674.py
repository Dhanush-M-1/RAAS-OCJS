# Hello World program in Python
def pow2(n):
    count=0
    while(n%2==0):
        n=n/2 
        count+=1
    return count 
def pow3(n):
    count=0
    while(n%3==0):
        n=n/3 
        count+=1
    return count     
for _ in range(int(input())):
    n=int(input())
    
    x=pow3(n)
    y=pow2(n)
    if(n==1):
        print(0)
        continue
    if(x==0):
        print(-1)
        continue
    
    if x<y:
        print(-1)
        continue
    if(x>=y):
        n=n*pow(2,x-y)
        n=n/pow(6,x)
        
        if(n==1):
            print(2*x-y)
        else:
            print(-1)
    