for t in range(int(input())):
    n = int(input())
    l = list(map(int, input().split()))
    temp = []
    if l[0] != -1 and l[1] == -1:
        temp.append(l[0])
    for i in range(1, n - 1):
        if l[i] != -1 and (l[i-1] == -1 or l[i+1] == -1):
            temp.append(l[i])
    if l[n-1] != -1 and l[n-2] == -1:
        temp.append(l[n-1])
    if len(temp) == 0:
        print(0, 0)
        continue
    mi = min(temp)
    ma = max(temp)
    no = (ma + mi) // 2
    dif = 0
    for i in range(n - 1):
        if l[i] == -1:
            l[i] = no
        if l[i+1] == -1:
            l[i+1] = no
        if abs(l[i] - l[i+1]) > dif:
            dif = abs(l[i] - l[i+1])
    print(dif, no)