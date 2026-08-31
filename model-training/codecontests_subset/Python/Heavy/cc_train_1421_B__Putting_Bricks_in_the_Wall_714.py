for _ in range(int(input())):
    
    nn=input()
    if nn=='':
        n=int(input())
    else:
        n=int(nn)

    l=[]
    for _ in range(n):
        aa=input()
        if aa=='':
            a=list(input())
        else:
            a=list(aa)
        l.append(a)

    s1=l[0][1]
    s2=l[1][0]
    f1=l[n-2][n-1]
    f2=l[n-1][n-2]
    
    if s1=='0' and s2=='0':
        if f1=='0' and f2=='0':
            print(2)
            print(1,2)
            print(2,1)
        elif f1=='0' and f2=='1':
            print(1)
            print(n-1,n)
        elif f1=='1' and f2=='0':
            print(1)
            print(n,n-1)
        elif f1=='1' and f2=='1':
            print(0)
    elif s1=='0' and s2=='1':
        if f1=='0' and f2=='0':
            print(1)
            print(1,2)
        elif f1=='0' and f2=='1':
            print(2)
            print(1,2)
            print(n,n-1)
        elif f1=='1' and f2=='0':
            print(2)
            print(1,2)
            print(n-1,n)
        elif f1=='1' and f2=='1':
            print(1)
            print(2,1)
    elif s1=='1' and s2=='0':
        if f1=='0' and f2=='0':
            print(1)
            print(2,1)
        elif f1=='0' and f2=='1':
            print(2)
            print(1,2)
            print(n-1,n)
        elif f1=='1' and f2=='0':
            print(2)
            print(1,2)
            print(n,n-1)
        elif f1=='1' and f2=='1':
            print(1)
            print(1,2)
    elif s1=='1' and s2=='1':
        if f1=='0' and f2=='0':
            print(0)
        elif f1=='0' and f2=='1':
            print(1)
            print(n,n-1)
        elif f1=='1' and f2=='0':
            print(1)
            print(n-1,n)
        elif f1=='1' and f2=='1':
            print(2)
            print(1,2)
            print(2,1)