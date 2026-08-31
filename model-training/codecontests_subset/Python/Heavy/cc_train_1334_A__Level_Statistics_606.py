for test in range(int(input())):
    a = []
    for _ in range(int(input())):
        a.append(tuple(map(int, input().split())))
    if a[0][0] >= a[0][1]:
        ans = "YES"
    else:
        print("NO")
        continue
    for i in range(1, len(a)):
        if a[i][0] < a[i][1]:
            ans = "NO"
            break
        if a[i][0] > a[i - 1][0]:
            c_access = a[i][0] - a[i - 1][0]
        elif a[i][0] == a[i - 1][0]:
            c_access = 0
        else:
            ans = "NO"
            break
        if a[i][1] - a[i - 1][1] > c_access or a[i][1] < a[i - 1][1]:
            ans = "NO"
            break
    print(ans)