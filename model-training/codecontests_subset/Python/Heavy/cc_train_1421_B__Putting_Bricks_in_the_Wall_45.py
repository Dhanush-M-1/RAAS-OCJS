cases = int(input())
for t in range(cases):
    n = int(input())
    s = []
    for i in range(n):
        s.append(list(input()))
    l = [int(s[-1][-3]),int(s[-1][-2]),int(s[-2][-2]),int(s[-2][-1]),int(s[-3][-1])]
    l1 = [1,0,1,0,1]
    l2 = [0,1,0,1,0]
    o1 = [l1[i]!=l[i] for i in range(5)]
    o2 = [l2[i] != l[i] for i in range(5)]
    so1 =sum(o1)
    so2 = sum(o2)
    if so1 <= so2:
        print(so1)
        if so1:
            if o1[0]:
                print(n,n-2)
            if o1[1]:
                print(n,n-1)
            if o1[2]:
                print(n-1,n-1)
            if o1[3]:
                print(n-1,n)
            if o1[4]:
                print(n-2,n)
    else:
        print(so2)
        if so2:
            if o2[0]:
                print(n,n-2)
            if o2[1]:
                print(n,n-1)
            if o2[2]:
                print(n-1,n-1)
            if o2[3]:
                print(n-1,n)
            if o2[4]:
                print(n-2,n)