from math import *
l=int(input())
lo=[]
res=0
reso=[]
for i in range(l):
    x=int(input())
    if x%3!=0:
        if x==1:
            res=0
        else:
            res=-1
    else:
        j,k=0,0
        
        while x==floor(x):
            x=x/3
            j+=1
        x=x*3
        while x==floor(x):
            x=x/2
            k+=1
        x=x*2
        if x==1:
            if j>=k:
                res=2*(j-1)-(k-1)
            else:
                res=-1
        else:
            res=-1
            
        
        
    reso.append(res)

for i in reso:
    print(i)
        
