q = int(input())
for _ in range(q):
    n = int(input())
    a = list(map(int, input().split()))
    b = []
    cnt = 0
    fail = 0
    for i in range(n):
        b.append(cnt)
        if i <= n/2-1:
            cnt += 1
        else:
            cnt -= 1
    if n % 2 == 0:
        for i in range(int(n/2)+1, n):
            b[i] -= 1
    for i in range(n):
        if a[i] < b[i]:
            fail = 1
            break
 
    if fail == 0:
        print("Yes")
    else:
        fail = 0
        b.reverse()
        for i in range(n):
            if a[i] < b[i]:
                fail = 1
                break
        if fail == 0:
            print("Yes")
        else:
            print("No")