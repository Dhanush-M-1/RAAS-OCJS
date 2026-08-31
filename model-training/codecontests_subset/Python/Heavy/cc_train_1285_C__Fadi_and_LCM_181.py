a=int(input())
d=[]

import math

if a==1:
    print(1,1)
else:
    for i in range (1,int(a**0.5)+1):
        if a%i==0:
            if a/i ==i:
                d.append(i)
            else:
                d.append(i)
                d.append(int(a/i))
    d.sort()
    if len(d)%2!=0:
        for i in range(int(len(d)/2)):
            if (d[int(len(d)/2)-1-i]*d[int(len(d)/2)+1+i])/math.gcd(d[int(len(d)/2)-1-i],d[int(len(d)/2)+1+i]) ==a:
                
                print(d[int(len(d)/2)-1-i],d[int(len(d)/2)+1+i])
                break
    else:
        for i in range(int(len(d)/2)):
            if (d[int(len(d)/2)-1-i]*d[int(len(d)/2)+i])/math.gcd(d[int(len(d)/2)-1-i],d[int(len(d)/2)+i]) ==a:
                print(d[int(len(d)/2)-1-i],d[int(len(d)/2)+i])
                break
            