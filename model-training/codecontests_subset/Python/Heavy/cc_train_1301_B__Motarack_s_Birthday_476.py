tc = int(input())
for T in range(tc):
    n = int(input())
    arr = list(map(int, input().split()))
    temp = []
    for i in range(n):
        if arr[i] != -1:
            if i == 0:
                if arr[i+1] ==- 1:
                    temp.append(arr[i])
            elif i == n-1:
                if arr[i-1] == -1:
                    temp.append(arr[i])
            else:
                if arr[i+1] == -1 or arr[i-1] == -1:
                    temp.append(arr[i])
    siz = len(temp)
    if siz >= 2:
        temp.sort()
        snd = (temp[0]+temp[siz-1])//2
    else:
        if siz == 0:
            snd = 0
        else:
            snd = temp[0]
    for i in range(n):
        if arr[i] == -1:
            arr[i] = snd
    fst = -1
    for i in range(n-1):
        dif = abs(arr[i]-arr[i+1])
        fst = max(fst, dif)
    print(fst, snd)
