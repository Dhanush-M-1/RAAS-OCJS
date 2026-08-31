ts = int(input())
#def pr(a):
#    print(str(a[0]) + " " + str(a[1]) )
for t in range(ts):
    n = int(input())
    l1 = []
    #l2 = []
    if n==3:

        for j in range(n):
            l1.append(input())
        #s1,s2,f1,f2 = [int(l[0][1]),int(l[1][0]),int(l[n-1][n-2]),int(l[n-2][n-1])]

        la = [int(l1[0][1]),int(l1[1][0]),int(l1[n-1][n-2]),int(l1[n-2][n-1])]
    else:
        l1.append(input())
        l1.append(input())
        for j in range(n-4):
            axw = input()
        l1.append(input())
        l1.append(input())
        la = [int(l1[0][1]),int(l1[1][0]),int(l1[-1][-2]),int(l1[-2][-1])]

    #l = [(1,2),(2,1),(n,n-1),(n-1,n)]
    l = ["1 2", "2 1", str(n)+ " "+str(n-1), str(n-1)+" "+str(n)]
    if sum(la) in [0,4]:
        print(2)
        print(l[0])
        print(l[1])
    elif sum(la)==1:
        print(1)
        if sum(la[:2])==1:
            if la[0]==0:
                print(l[0])
            else:
                print(l[1])
        else:
            if la[2]==0:
                print(l[2])
            else:
                print(l[3])

    elif sum(la)==3:
        print(1)
        if sum(la[:2])==1:
            if la[0]==1:
                print(l[0])
            else:
                print(l[1])
        else:
            if la[2]==1:
                print(l[2])
            else:
                print(l[3])

    elif sum(la)==2:
        if sum(la[:2]) in [0,2]:
            print(0)
        else:
            print(2)
            if la[0]==1:
                print(l[0])
            else:
                print(l[1])
            if la[3]==0:
                print(l[3])
            else:
                print(l[2])


