t = int(input())
for _ in range(t):
    N = int(input())
    a = list(map(int, input().split()))

    flag = True
    id = 0
    for i in range(N):
        if a[i] >= i:
            if i == N-1:
                id = i+1
        else:
            id = i
            break

    for i in range(id, N):
        if a[i-1] > a[i]:
            continue
        else:
            a[i] = a[i-1]-1
            if a[i] < 0:
                flag = False
                break
    if flag:
        print("Yes")
        # print(a)
    else:
        print("No")
