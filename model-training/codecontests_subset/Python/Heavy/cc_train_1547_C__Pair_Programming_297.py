
T = int(input())

for _ in range(T):

    s = input()

    k,n,m = input().split()
    k = int(k)
    n = int(n)
    m = int(m)

    a = input().split()
    a = list(map(int, a))
    b = input().split()
    b = list(map(int, b))
    
    p1 = 0
    p2 = 0
    temp = 0
    ans = []

    flag = 0

    while p2<m and p1<n:
        temp = 0
        if a[p1] == 0:
            k+=1
            temp = 0
            ans.append(a[p1])
            temp = 0
            p1 +=1
        elif b[p2] == 0:
            temp = 0
            k+=1
            ans.append(b[p2])
            temp = 0
            p2+=1
        elif a[p1] > k and b[p2] >k:
            temp = 0
            print(-1)
            flag = 1
            break
        elif a[p1] >k:
            temp = 0
            ans.append(b[p2])
            p2 += 1
            temp = 0
        else:
            ans.append(a[p1])
            temp = 0
            p1+=1

    if flag == 1:
        continue

    while p1<n:
        temp = 0
        if a[p1] == 0:
            ans.append(0)
            temp = 0
            k+=1
            p1+=1
            temp = 0
        elif a[p1] <=k:
            ans.append(a[p1])
            temp = 0
            p1+=1
        else:
            temp = 0
            flag = 1
            print(-1)
            break

    if flag == 1:
        continue

    while p2<m:
        temp = 0
        if b[p2] == 0:
            ans.append((b[p2]))
            temp = 0
            k+=1
            p2+=1
            temp = 0
        elif b[p2] <=k:
            ans.append(b[p2])
            p2+=1
            temp = 0
        else:
            temp = 0
            flag = 1
            print(-1)
            break

    if flag == 1:
        continue

    print(*ans)

