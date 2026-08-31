t = int(input())
for _ in range(t):
    
    n = int(input())
    matrix = list()
    for i in range(n):
        a = list(input())
        matrix.append(a)
    switch = list()
    count = 0
    if matrix[0][1] == matrix[1][0]:
        common = matrix[0][1]
        if matrix[n-1][n-2] == common:
            switch.append(str(n) + " " + str(n-1))
            count += 1
        if matrix[n-2][n-1] == common:
            switch.append(str(n-1) + " " + str(n))
            count += 1
    elif matrix[n-1][n-2] == matrix[n-2][n-1]:
        common = matrix[n-1][n-2]
        if matrix[1][0] == common:
            switch.append(str(2) + " " + str(1))
            count += 1
        if matrix[0][1] == common:
            switch.append(str(1) + " " + str(2))
            count += 1
    else:
        if matrix[0][1] != '0':
            switch.append(str(1) + " " + str(2))
            count += 1
        if matrix[1][0] != '0':
            switch.append(str(2) + " " + str(1))
            count += 1
        if matrix[n-1][n-2] != '1':
            switch.append(str(n) + " " + str(n-1))
            count += 1
        if matrix[n-2][n-1] != '1':
            switch.append(str(n-1) + " " + str(n))
            count += 1
    print(count)
    print(*switch, sep="\n")