def gcd(a,b):
    if a == 0:
        return b
    return gcd(b % a, a)

def lcm(a,b):
    return (a*b) / gcd(a,b)

def div(n) :
    q=[]
    i = 1
    while i <= math.sqrt(n):

        if (n % i == 0) :
            if (n / i == i) :
                q.append(i)
            else :
                q.append(i)
                q.append(n//i)
        i = i + 1
    return(q)

import math

x=int(input())
l=div(x)
l.sort()

d={}
ans=10**13
for i in range(len(l)):
    u=x//l[i]
    if l[i] in d:
        break
    else:
        d[l[i]]=1

    if lcm(l[i],u)==x:
        temp=max(l[i],u)
        ans=min(ans,temp)

print(ans,x//ans)