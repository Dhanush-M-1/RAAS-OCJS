# cook your dish here
import math;
for _ in range(int(input())):
    n=int(input())
    x=[]
    for i in range(n):
        x.append(input())
    a,b,c,d=x[1][0],x[0][1],x[n-1][n-2],x[n-2][n-1]    
    if(a==b and c==d):
        if(a==c):
            print(2)
            print(1,2)
            print(2,1)
        else:
            print(0)
    elif(a==b):
        print(1)
        if(a=="1"):
            if(c=="1"):
                print(n,n-1)
            else:
                print(n-1,n)
        else:
            if(c=="0"):
                print(n,n-1)
            else:
                print(n-1,n)
    elif(d==c):
        print(1)
        if(c=="1"):
            if(a=="1"):
                print(2,1)
            else:
                print(1,2)
        else:
            if(a=="0"):
                print(2,1)
            else:
                print(1,2)  
    else:
        print(2)
        if(a=="0"):
            print(2,1)
        else:
            print(1,2)
        if(c=="1"):
            print(n,n-1)
        else:    
            print(n-1,n)
                