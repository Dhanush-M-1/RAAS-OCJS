t = int(input())

for i in range(t):
    n = int(input())
    m = int(1e9) + 1
    M = -1
    max_dif = 0
    a = list(map(int, input().split()))
    for j in range(len(a)):
        if a[j] == -1:
            if j+1 < len(a):
                if a[j+1] < m and a[j+1] != -1:
                    m = a[j+1]
                if a[j+1] > M:
                    M = a[j+1]
            if j-1 >= 0:
                if a[j-1] < m and a[j-1] != -1:
                    m = a[j-1]
                if a[j-1] > M:
                    M = a[j-1]
        else:
                if j+1 < len(a):
                        if abs(a[j] - a[j+1]) > max_dif and a[j+1] != -1:
                                max_dif = abs(a[j] - a[j+1])
                if j-1 >= 0:
                        if abs(a[j] - a[j-1]) > max_dif and a[j-1] != -1:
                                max_dif = abs(a[j] - a[j-1])
    if m == int(1e9) + 1 and M == -1:
        print('0 0')
    else:
            l = max((M-m)//2+(M-m)%2, max_dif)
            k = m + (M-m)//2
            print(l, k)
