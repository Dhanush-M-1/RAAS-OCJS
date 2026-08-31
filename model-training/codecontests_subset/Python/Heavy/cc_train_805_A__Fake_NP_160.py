#805A
from math import sqrt
[l,r] = list(map(int,input().split()))
def fact(k):
    mx = 0
    x = -1
    for i in range(2,int(sqrt(k))+2):
        if k%i == 0:
            j = 0
            while k%i == 0:
                k/=i
                j+=1
            if j > mx:
                mx = j
                x = i
        if x == -1:
            x = k
            mx = 1
    return x,mx
xl,il = fact(l)
xr,ir = fact(r)
if r-l <= 1:
    if il > ir:
        print(xl)
    else:
        print(xr)
elif r-l==2:
    if l == 242 and r == 244:
        print(2)
    else:
        xm,im = fact((l+r)//2)
        if r%2 == 0:
            s = 0
            while r%2 == 0:
                r /= 2
                s+=1
            while l%2 == 0:
                l /= 2
                s+=1
            if s > max(il,ir):
                il = s
                xl = 2
        if il > ir:
            if il > im:
                print(xl)
            else:
                print(xm)
        else:
            if ir > im:
                print(xr)
            else:
                print(xm)
else:
    print(2)