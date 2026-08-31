r = [5, 7, 5, 7, 7]
while True:
    n = int(input())
    if n == 0:
        break
    w = []
    for _ in range(n):
        w.append(len(input()))
    for j in range(n):
        i = j
        for k in r:
            s = 0
            while s < k:
                s = s + w[i]
                i = i + 1
            if s != k:
                break
        else:
            print(j+1)
            break