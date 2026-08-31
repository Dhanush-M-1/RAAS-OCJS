while True:
    n = int(input())
    if n == 0:
        break
    w = []
    go = 0
    flag = True
    x = 0
    count = 0
    for i in range(n):
        w.append(input())
    else:
        while count < 5:
            for i in range(x,n):
                go += len(w[i])
                if flag == True:
                    if go == 5:
                        flag = False
                        count += 1
                        go = 0
                    if go > 5:
                        x += 1
                        go = 0
                        count = 0
                        break
                if flag == False:
                    if go == 7 and count == 3:
                        flag = False
                        count += 1
                        go = 0
                    if go == 7:
                        flag = True
                        count += 1
                        go = 0
                    if go > 7:
                        x += 1
                        go = 0
                        count = 0
                        flag = True
                        break
                if count == 5:
                    break
    print(x + 1)

