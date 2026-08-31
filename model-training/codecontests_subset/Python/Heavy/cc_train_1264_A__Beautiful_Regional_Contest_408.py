from math import sqrt,ceil
def ii():return int(input())
def mi():return map(int,input().split())
def li():return list(mi())
def si():return input()
abc=['a','b','c']
t=ii()
while(t):
    t-=1
    n=ii()
    a=li()
    ma=n//2
    x=a[ma]
    for i in range(ma,-1,-1):
        if(a[i-1]!=a[ma]):
            break
    b=a[:i]
    b=list(set(b))
    b.sort(reverse=True)
    if(len(b)>=3):
        n1=a.count(a[0])
        n2=i-n1
        s=0
        for k in range(1,len(b)):
            s+=a.count(b[k])
            if(s>n1):
                break
        b=n2-s
        if(n1<s and n1<b):
            print(n1,end=" ")
            print(s,end=" ")
            print(b)
        else:
            print("0 0 0")
    else:
        print("0 0 0")
        