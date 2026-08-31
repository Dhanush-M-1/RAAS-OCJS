def count(n):
    c=0
    while(n>0):
        if(n%3==0):
            n=n//3
            c+=1
        elif(n==1):
            return (2*c)
        else:
            break
    if(p(n,c)>0):
        return ((2*c)-p(n,c))
    else:
        return -1
def p(n,c):
    t=0
    while(n>0):
        if(n%2==0):
            n=n//2
            t+=1
        elif(n==1):
            if(c<t):
                return -1
            else:
                return t
        else:
            return -1
for i in range(int(input())):
    n=int(input())
    if(n==1):
        print(0)
    elif(n%3==0):
        m=count(n)
        print(m)
    else:
        print(-1)