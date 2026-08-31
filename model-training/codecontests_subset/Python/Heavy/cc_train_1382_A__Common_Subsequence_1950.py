t = int(input())

for i in range(t) :
    n,m = map(int,input().split())
    a = list(map(int,input().strip().split()))[:n]
    b = list(map(int,input().strip().split()))[:m]
    flag = 0
    num = 0
    if n >= m :
        for j in range(m) :
            if b[j] in a :
                flag = 1
                num = b[j]
                break
    else :
        for j in range(n) :
            if a[j] in b :
                flag = 1
                num = a[j]
                break

    if flag == 1 :
        print('YES')
        print(1,num)
    else :
        print('NO')

