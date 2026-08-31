 
import math
t=int(input())

list=[]


def vtwo(n):
    if n%2!=0:
        return 0
    else:
        c=0
        while n%2==0:
            n=n/2
            c+=1
        return c

def vthree(n):
    if n%3!=0:
        return 0
    else:
        c=0
        while n%3==0:
            n=n/3
            c+=1
        return c

for x in range(1,t+1):
    n=int(input())
    if n==1:
        list.append(0)
    elif vthree(n)==0:
        list.append(-1)
    else:
        if n/(2**vtwo(n)*3**vthree(n))!=1:
            list.append(-1)
        elif vthree(n)-vtwo(n)<0:
            list.append(-1)
        else:
            list.append(2*vthree(n)-vtwo(n))

for x in list:
    print(x)


