T=int(input())
for z in range(T):
    n=int(input())

    l=list()
    for i in range(n):
        s=input()

        l.append(s)

    det1=(l[n-1][n-3]+l[n-2][n-2]+l[n-3][n-1])

    det2=(l[n-1][n-2]+l[n-2][n-1])

    if det2=="11":
        if det1=="111":
            print(2)
            print(n-1,n)
            print(n,n-1)

        elif det1=="110":
            print(2)
            print(n,n-2)
            print(n-1,n-1)

        elif det1=="101":
            print(2)
            print(n,n-2)
            print(n-2,n)

        elif det1=="100":
            print(1)
            print(n,n-2)

        elif det1=="011":
            print(2)
            print(n-1,n-1)
            print(n-2,n)

        elif det1=="010":
            print(1)
            print(n-1,n-1)

        elif det1=="001":
            print(1)
            print(n-2,n)

        elif det1=="000":
            print(0)
        
    elif det2=="00":
        if det1=="000":
            print(2)
            print(n-1,n)
            print(n,n-1)

        elif det1=="001":
            print(2)
            print(n,n-2)
            print(n-1,n-1)

        elif det1=="010":
            print(2)
            print(n,n-2)
            print(n-2,n)

        elif det1=="011":
            print(1)
            print(n,n-2)

        elif det1=="100":
            print(2)
            print(n-1,n-1)
            print(n-2,n)

        elif det1=="101":
            print(1)
            print(n-1,n-1)

        elif det1=="110":
            print(1)
            print(n-2,n)

        elif det1=="111":
            print(0)
            
    elif det2=="10":
        if det1=="111":
            print(1)
            print(n,n-1)

        elif det1=="110":
            print(2)
            print(n,n-1)
            print(n-2,n)
            

        elif det1=="101":
            print(2)
            print(n-1,n-1)
            print(n,n-1)

        elif det1=="100":
            print(2)
            print(n,n-2)
            print(n-1,n)

        elif det1=="011":
            print(2)
            print(n,n-2)
            print(n,n-1)

        elif det1=="010":
            print(2)
            print(n-1,n-1)
            print(n-1,n)

        elif det1=="001":
            print(2)
            print(n-2,n)
            print(n-1,n)

        elif det1=="000":
            print(1)
            print(n-1,n)
    elif det2=="01":
        if det1=="000":
            print(1)
            print(n,n-1)

        elif det1=="001":
            print(2)
            print(n,n-1)
            print(n-2,n)
            

        elif det1=="010":
            print(2)
            print(n-1,n-1)
            print(n,n-1)

        elif det1=="011":
            print(2)
            print(n,n-2)
            print(n-1,n)

        elif det1=="100":
            print(2)
            print(n,n-2)
            print(n,n-1)

        elif det1=="101":
            print(2)
            print(n-1,n-1)
            print(n-1,n)

        elif det1=="110":
            print(2)
            print(n-2,n)
            print(n-1,n)

        elif det1=="111":
            print(1)
            print(n-1,n)
