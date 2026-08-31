import math
def primeFactors(n,d):
    d={2:0,3:0}
    while(n%6==0):
        d[2]+=1
        d[3]+=1
        n=n//6
    while(n%3==0):
        d[3]+=1
        n=n//3
    while(n%2==0):
        d[2]+=1
        n=n//2
        
    if(n!=1):
        return (d,-1)
    return (d,1)
 
 
for _ in range(int(input())):
    x=primeFactors(int(input()),{})
    if(x[1]==-1):
        print(-1)
    else:
        d=x[0]
        if(d[2]>d[3]):
            print(-1)
        elif(d[2]==d[3]):
            print(d[2])
        else:
            print(d[3]+d[3]-d[2])