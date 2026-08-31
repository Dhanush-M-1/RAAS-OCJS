a=int(input())
b=int(input())
y=0
t=0
if (b>a):
    z=(b-a)
    if (z%2==0):
        d=(z//2)
        for i in range(1,d+1):
            y=y+i
        p=2*y
        print(p)
    else:
        o=(b-a-1)//2
        e=(b-a+1)//2
        for i in range (1,o+1):
            y=y+i
        for w in range (1,e+1):
            t=t+w
        print(y+t)    
elif (b<a):
    z=(a-b)
    if (z%2==0):
        d=(z//2)
        for i in range(1,d+1):
            y=y+i
        p=2*y
        print(p)
    else:
        o=(a-b-1)//2
        e=(a-b+1)//2
        for i in range (1,o+1):
            y=y+i
        for w in range (1,e+1):
            t=t+w
        print(y+t)    
else:
    print("0")