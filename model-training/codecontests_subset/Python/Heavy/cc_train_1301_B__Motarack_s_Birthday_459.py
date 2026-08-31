t = int(input())
for _ in range(t):
    n = int(input())
    arr = list(map(int,input().split()))
    tar = []
    for i in range(n-1):
        if arr[i] != -1 and arr[i+1] == -1:
            tar.append(arr[i])
        elif arr[i] == -1 and arr[i+1] != -1:
            tar.append(arr[i+1])
    tar.sort()
    if not tar:
        print(0,0)
    else:
        k = (tar[0] + tar[-1] + 1) // 2
        m = 0
        for i in range(n):
            if arr[i] == -1:
                arr[i] = k
        for i in range(n-1):
            m = max(m, abs(arr[i]-arr[i+1]))
        print(m,k)
