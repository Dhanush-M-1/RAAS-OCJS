def solve():
    lis = []
    flag = True
    n = int(input())
    
    for _ in range(n):
        lis.append([int(x) for x in input().split()])
    if n == 1:
        if lis[0][0] < lis[0][1]:
            flag = False    
        else:
            flag = True    
    else:    
        for i in range(n-1):
            p = lis[i][0]
            c = lis[i][1]
            p1 = lis[i+1][0]
            c1 = lis[i+1][1]
            if p1 < p or c1 < c or (p1-p) < (c1-c) or p < c:
                flag = False
                break 
    if flag:
        print("YES")
    else:
        print("NO")     


try:
    t = int(input())
    for _ in range(t):
        solve()
except:
    pass        