import math
t=int(input())
while t>0:
    n=int(input())
    c=0
    
    if(n==1):
        print(0)
    elif(n==3):
        print(2)
    elif(n==2):
        print(-1)
    else:
        s=0
        while True:
            if(n%6==0):
                c+=1
                n=int(n/6)
            elif((n*4)%6!=0 and n!=1):
                print(-1)
                break
            elif(n==1):
                print(c)
                break
        
            else:
                n=n*2
                c+=1
        #print(c)
        
    t-=1
