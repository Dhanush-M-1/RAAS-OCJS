import math
def f(l,r, arr, count):
    global tb
    if l >= r:
        return 0
    m= 0
    for j in range(l, r + 1):
        m = max(m, arr[j])
    ind = arr.index(m)
    tb[ind] = count
    f(l, ind - 1, arr, count + 1)
    f(ind+ 1, r, arr, count + 1)
test = int(input())
while test > 0:
    test -= 1
    n= int(input())
    tb = [-1 for p in range(n)]
    arr = list(map(int, input().split()))
    if n == 1:
        print(0)
    else:
        f(0, n - 1, arr, 0)
        if tb[0] == -1:
            print(tb[1]+ 1, end= " ")
        else:
            print(tb[0], end = " ")
        for h in range(1,len(tb) - 1):
            if tb[h] == -1:
                print(max(tb[h-1], tb[h+1])+ 1, end= " ")
            else:
                print(tb[h], end= " ")
        if tb[-1] == -1:
            print(tb[-2] + 1, end= " ")
        else:
            print(tb[-1], end= " ")
        print()
        
    


