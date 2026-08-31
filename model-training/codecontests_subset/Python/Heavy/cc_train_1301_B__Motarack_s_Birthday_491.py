import math
t = int(input())
while t:
    t += -1
    n = int(input())
    l = list(map(int, input().split()))
    arr = []
    check = 0
    for i in l:
        if i != -1: check = 1
    if check == 0: print("0 1")
    else:
        for i in range(n):
            if l[i] == -1:
                if i == 0:
                    if l[1] != -1: arr.append(l[1])
                elif i == n - 1:
                    if l[n - 2] != -1: arr.append(l[n - 2])
                else:
                    if l[i - 1] != -1: arr.append(l[i - 1])
                    if l[i + 1] != -1: arr.append(l[i + 1])
        arr = list(set(arr))
        arr.sort()
        avg = math.ceil((arr[0] + arr[len(arr) - 1]) / 2)
        # avg = sum(arr) / len(arr)
        l2 = []
        for i in l: 
            if i != -1: l2.append(i)
            else: l2.append(avg)
        mx1 = 0
        for i in range(n - 1):
            if abs(l2[i] - l2[i + 1]) > mx1: mx1 = abs(l2[i] - l2[i + 1])
        mx2 = 0
        avg += -1
        l2 = []
        for i in l: 
            if i != -1: l2.append(i)
            else: l2.append(avg)
        for i in range(n - 1):
            if abs(l2[i] - l2[i + 1]) > mx2: mx2 = abs(l2[i] - l2[i + 1])
        if mx2 < mx1: print(mx2, avg)
        else: print(mx1, avg + 1)