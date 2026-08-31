"""def power(x, y): 
    res = 1
    x=x
    while (y > 0): 
        if ((y & 1) == 1) : 
            res = (res * x) 
        y = y >> 1
        x = (x * x)
    return res""" 
"""def fact(n):
    if(n==0):
        return 1
    if(n==1):
        return 1
    return fact(n-1)+fact(n-2)"""

t=int(input())
for _ in range(t):
    n=int(input())
    #n,k=map(int,input().split())
    arr=list(map(int,input().split()))
    d=dict()
    l=list()
    count=0
    l1=list()
    g=0
    b=0
    s=0
    j=0
    for i in range(n):
        if arr[i] not in d:
            d[arr[i]]=1
            l.append(arr[i])
        else:
            d[arr[i]]+=1
    for i in range(len(l)):
        l1.append(d[l[i]])
    summ=n//2
    su=0
    index=0
    for i in range(len(l1)):
        if(summ>=l1[i]+su):
            su=su+l1[i]
            index=i
        else:
            break
    if(len(l)<3):
        print("0 0 0")
    else:
        
        if(index<2):
            print("0 0 0")
        else:
            g=l1[0]
            for i in range(1,index+1):
                if(s<=g):
                    s=s+l1[i]
                    j=i
                else:
                    break
            for i in range(j+1,index+1):
                b=b+l1[i]
            if(g==0 or b==0 or s==0):
                print("0 0 0")
            else:
                if(g>=s or g>=b):
                    print("0 0 0")
                else:
                    print(g,s,b)
    
        
