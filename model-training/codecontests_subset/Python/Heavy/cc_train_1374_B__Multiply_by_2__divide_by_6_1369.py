def p3(x):
    p3c=0
    while(1>0):
        if(x%3==0):
            x=x//3
            p3c+=1
        else:
            break
    return p3c
def p2(x):
    p2c=0
    while(1>0):
        if(x%2==0):
            x=x//2
            p2c+=1
        else:
            break
    return p2c

t=int(input())
for i in range(t):
    n=int(input())
    po3=p3(n)
    po2=p2(n)
    if(po3<po2):
        print(-1)
    else:
        reduced=n/((3**po3)*(2**po2))
        if(reduced!=1):
            print(-1)
        else:
            print(2*po3-po2)