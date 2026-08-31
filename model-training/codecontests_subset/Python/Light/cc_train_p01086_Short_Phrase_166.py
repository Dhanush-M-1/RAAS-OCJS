fs = [5, 7, 5, 7, 7]
while True:
    flag = 0
    n = int(input())
    if n == 0:
        quit()
    w = []
    for i in range(n):
        w.append(len(input()))
    for i in range(len(w)):
        k, temp = 0, 0
        for j in range(i, len(w)):
            temp += w[j]
            if temp > fs[k]:
                break
            elif temp == fs[k]:
                if k == 4:
                    print(i+1)
                    flag = 1
                    break
                else:
                    k += 1
                    temp = 0
        if flag == 1:
            break

