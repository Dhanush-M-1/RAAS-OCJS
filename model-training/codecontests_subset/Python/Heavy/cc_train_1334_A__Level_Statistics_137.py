test = int(input())

sol = []

while test:

    test -= 1
    n = int(input())

    a = [tuple(map(int, input().split())) for i in range(n)]

    if n == 1:
        x = 'YES'
        if a[0][0] < a[0][1]:
            x = 'NO'
        sol.append(x)
    else:
        i = 1
        x = 'YES'
        if a[0][1] > a[0][0]:
            x = 'NO'
        while i < n and x == 'YES':
            if a[i][0] < a[i][1]:
                x = 'NO'
                break
            else:
                if a[i][0] < a[i - 1][0] or a[i][1] < a[i-1][1]:
                    x = 'NO'
                    break
                elif a[i][0] == a[i - 1][0]:
                    if a[i][1] != a[i - 1][1]:
                        x = 'NO'
                        break
                else:
                    if a[i][1] < a[i - 1][1]:
                        x = 'NO'
                        break
                    elif a[i][1] - a[i-1][1] > a[i][0] - a[i-1][0]:
                        x = 'NO'
                        break
            i += 1
        sol.append(x)

for i in sol:
    print(i)


