t = int(input())
for q in range(t):
    n = int(input())
    L = [int(i) for i in input().split()]
    cur = 0
    d = 1
    flag = 1
    for i in range(n - 1):
        if L[i] >= cur:
            cur += d
        else:
            if d == 1:
                d = -1
                cur = min(L[i] - 1, L[i - 1] - 2)
            else:
                cur = L[i] - 1
        #print(cur, end = ' ')
        if cur == 0 and i < n - 2:
            flag = 0
            break
        if cur < 0:
            flag = 0
            break
    if L == [0, 0]:
        flag = 0
    if flag:
        print("Yes")
    else:
        print("No")
    
