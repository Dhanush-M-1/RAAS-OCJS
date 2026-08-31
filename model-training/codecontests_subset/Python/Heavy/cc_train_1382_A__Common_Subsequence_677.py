for l in range(int(input())):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    a.sort()
    b.sort()
    c = []
    am = 0
    j1 = 0
    for i in range(n):
        for j in range(j1, m):
            if a[i] == b[j]:
                c.append(a[i])
                j1 += 1
                am = 1
                break
            elif a[i] < b[j]:
                break
            else:
                j1 += 1
        if am == 1:
            break
    if len(c) == 0:
        print('NO')
    else:
        print('YES')
        print(1, c[0])
        
    
                
        