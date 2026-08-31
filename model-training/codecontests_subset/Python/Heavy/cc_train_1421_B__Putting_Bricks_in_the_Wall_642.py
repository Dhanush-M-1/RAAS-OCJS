for i in range(int(input())):
    n=int(input())
    l=list()
    for i in range(n):
        x=input()
        lst=list()
        for i in x:
            lst.append(i)
        l.append(lst)
    l1=l[n-2][n-1]
    l2=l[n-1][n-2]
    f1=l[0][1]
    f2=l[1][0]
    if int(f1)==0 and int(f2)==0:
        if int(l1)==0 and int(l2)==0:
            print(2)
            print(n-2+1,n-1+1)
            print(n-1+1,n-2+1)
        elif int(l1)==1 and int(l2)==0:
            print(1)
            print(n-1+1,n-2+1)
        elif int(l1)==0 and int(l2)==1:
            print(1)
            print(n-2+1,n-1+1)
        else:
            print(0)
    elif int(f1)==1 and int(f2)==1:
        if int(l1)==1 and int(l2)==1:
            print(2)
            print(n-2+1,n-1+1)
            print(n-1+1,n-2+1)
        elif int(l1)==0 and int(l2)==1:
            print(1)
            print(n-1+1,n-2+1)
        elif int(l1)==1 and int(l2)==0:
            print(1)
            print(n-2+1,n-1+1)
        else:
            print(0)
    elif int(f1)==0 and int(f2)==1:
        if int(l1)==0 and int(l2)==0:
            print(1)
            print(1,2)
        elif int(l1)==1 and int(l2)==0:
            print(2)
            print(2,1)
            print(n-1+1,n-2+1)
        elif int(l1)==0 and int(l2)==1:
            print(2)
            print(2,1)
            print(n-2+1,n-1+1)
        else:
            print(1)
            print(2,1)
    elif int(f1)==1 and int(f2)==0:
        if int(l1)==0 and int(l2)==0:
            print(1)
            print(2,1)
        elif int(l1)==1 and int(l2)==0:
            print(2)
            print(1,2)
            print(n-1+1,n-2+1)
        elif int(l1)==0 and int(l2)==1:
            print(2)
            print(1,2)
            print(n-2+1,n-1+1)
        else:
            print(1)
            print(1,2)
