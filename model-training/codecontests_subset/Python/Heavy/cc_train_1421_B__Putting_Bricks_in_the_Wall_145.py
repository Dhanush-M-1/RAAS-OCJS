for _ in range(int(input())):
    n = int(input())
    l = []
    for i in range(n):
        l.append(list(str(input())))
    l2 = []
    a1 = 0
    a2 = 0
    a3 = 0
    a4 = 0
    c = 0
    a1+=2 - ((int(l[0][1])) + (int(l[1][0])))
    a2+=((int(l[0][1])) + (int(l[1][0])))
    a3 = 2 - ((int(l[n-1][n-2])) + (int(l[n-2][n-1])))
    a4+= ((int(l[n-1][n-2])) + (int(l[n-2][n-1])))
    if a1 == 0:
        if l[n-1][n-2] == "1":
            c+=1
            l2.append([n,n-1])
        if l[n-2][n-1] == "1":
            l2.append([n-1,n])
            c+=1
    elif a1 == 1:
        if a3 == 0:
            if l[1][0] == "1":
                c+=1
                l2.append([2,1])
            if l[0][1] == "1":
                l2.append([1,2])
                c+=1
        elif a3 == 1:
            if l[1][0] == "1":
                c+=1
                l2.append([2,1])
            if l[0][1] == "1":
                l2.append([1,2])
                c+=1
            if l[n-1][n-2] == "0":
                c+=1
                l2.append([n,n-1])
            if l[n-2][n-1] == "0":
                l2.append([n-1,n])
                c+=1
        else:
            if l[1][0] == "0":
                c+=1
                l2.append([2,1])
            if l[0][1] == "0":
                l2.append([1,2])
                c+=1
    else:
        if l[n-1][n-2] == "0":
            c+=1
            l2.append([n,n-1])
        if l[n-2][n-1] == "0":
            l2.append([n-1,n])
            c+=1
    if len(l2) == 0:
        print(0)
    else:
        print(c)
        for i in l2:
            print(*i)
        
        
            
                
            
            
            
        
        
