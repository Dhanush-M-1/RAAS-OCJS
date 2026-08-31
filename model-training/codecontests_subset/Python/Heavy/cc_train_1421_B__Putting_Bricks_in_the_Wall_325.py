for _ in range(int(input())):
    n = int(input())
    arr = list()
    for _ in range(n):
        arr.append(input())
    ss = arr[0][1]
    sd = arr[1][0]
    fu = arr[n-2][n-1]
    fl = arr[n-1][n-2]
    
    if ss == sd:
        if fu == fl:
            if ss!=fu:
                print(0)
            else :
                print(2)
                print(1,2)
                print(2,1)
        else:
            if ss==fu:
                print(1)
                print(n-1,n)
            else :
                print(1)
                print(n, n-1)
    else:
        if fu == fl:
            print(1)
            if ss==fu:
                print(1, 2)
            else : print(2,1)
        else:
            print(2)
            if(ss==fl):
                print(2,1)
                print(n,n-1)
            if(ss==fu):
                print(2,1)
                print(n-1,n)