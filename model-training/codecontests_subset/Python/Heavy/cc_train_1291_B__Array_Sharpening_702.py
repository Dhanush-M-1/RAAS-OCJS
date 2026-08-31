for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))
    t = 0
    p = 0
    if(n == 1):
        print("YES")
    else:    
        for i in range(n-1):
            if(a[i] > i) and (a[i+1] > i):
                a[i] = i
            if(a[i] < a[i+1]):
                continue
            else:
                p = 1
                break
        if(p == 1):    
            for j in range(n-1, i, -1):
                if(a[j] > n-j-1):
                    a[j] = n-j-1
                if(a[j] < a[j-1]):
                    continue
                else:
                    t = 1
                    break
            if(t == 0):
                print("YES")
            else:
                print('NO')
        else:
            print("YES")