for _ in range(int(input())):
    n = int(input())
    data = []
    for i in range(n):
        p, c = map(int, input().split())
        data.append((p, c))
    check = True
    if data[0][0] < data[0][1]:
        check = False
    else:
        for i in range(n - 1):
            if data[i][0] == data[i + 1][0] and data[i][1] == data[i + 1][1]:
                continue
            if data[i][0] < data[i + 1][0] and (data[i][1] <= data[i + 1][1] and data[i + 1][1] <= data[i][1] + (data[i + 1][0] - data[i][0])):
                continue
            check = False
            break
    if check:
        print("YES")
    else:
        print("NO")