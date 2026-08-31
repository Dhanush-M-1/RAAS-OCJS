t = int(input())
for ti in range(t):
    n = int(input())
    for i in range(n):
        s= input()
        if i==0:
            k1=int(s[1])
        if i==1:
            k2=int(s[0])
        if i==n-2:
            k3=int(s[-1])
        if i==n-1:
            k4=int(s[-2])
    #print(k1,k2,k3,k4)
    if k1==k2:
        if k3==k4==k1:
            print(2)
            print(1, 2)
            print(2, 1)
        elif k3==k4==1-k1:
            print(0)
        elif k3==k1:
            print(1)
            print(n-1,n)
        else:
            print(1)
            print(n,n-1)
    elif k3==k4:
        if k1==k3==1-k2:
            print(1)
            print(1, 2)
        elif k2==k3==1-k1:
            print(1)
            print(2, 1)
    elif k2==k3:
        print(2)
        print(1,2)
        print(n-1,n)
    else:
        print(2)
        print(2,1)
        print(n-1,n)
        
        