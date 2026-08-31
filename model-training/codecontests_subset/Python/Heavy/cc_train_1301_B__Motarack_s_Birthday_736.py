t = int(input())
for _ in range(t):
    n = int(input())
    l = list(map(int, input().split()))
    temp = []
    for i in range(n):
        if l[i] == -1:
            if i == 0:
                if l[i+1] != -1:
                    temp.append(l[i+1])
            elif i == n-1:
                if l[i-1] != -1:
                    temp.append(l[i-1])
            else:
                if l[i-1] != -1:
                    temp.append(l[i-1])
                if l[i+1] != -1:
                    temp.append(l[i+1])
    temp = list(set(temp))
    temp.sort()
    if len(temp) == 0:
        k = 42
    else:
        k = (temp[0]+temp[-1])//2
    #print(k)
    l_ = [0]*n
    for i in range(n):
        if l[i] == -1:
            l_[i] = k
        else:
            l_[i] = l[i]
    m = 0
    for i in range(n-1):
        m = max(m, abs(l_[i+1]-l_[i]))
    print(m, k)
