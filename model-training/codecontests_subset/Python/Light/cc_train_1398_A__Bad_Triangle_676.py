t = int(input())
flag = bool(False)

for q in range(t):
    a = []
    flag = False
    c = int(input())
    
    a = list(map(int, input().split()))
    
    for e in range (1, c-1):
        if (a[0] + a[e] <= a[c-1]):
            flag = True
            break
        
    if (flag == True):
        print (1, e+1, c)
    else:
        print(-1)
