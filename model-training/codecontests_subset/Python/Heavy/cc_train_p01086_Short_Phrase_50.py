while True:
    n = int(input())
    if n == 0:
        break
    short = [5, 7, 5, 7, 7]
    phase = 0
    res = -1
    arr = [0 for i in range(n)]
    for i in range(n):
        arr[i] = len(list(input()))
    for i in range(n):
        tmpsum = 0
        phase = 0
        for j in range(i, n):
            tmpsum += arr[j]
            if tmpsum > short[phase]:
                break
            if tmpsum == short[phase]:
                if phase == 4:
                    res = i + 1
                    break
                tmpsum = 0
                phase += 1
        if res > 0:
            print(res)
            break

