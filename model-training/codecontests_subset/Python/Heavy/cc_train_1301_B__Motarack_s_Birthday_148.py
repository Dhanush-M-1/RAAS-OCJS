for _ in range(int(input())):
    n = int(input())
    array = list(map(int, input().split()))
    ## addressing the special case
    if array.count(-1) == n:
        print(*(0, 69))
        continue
    mini = 1e1000; maxi = -1e1000;
    for i in range(n):
        if array[i] == -1:
            if i-1 >= 0:
                if array[i-1] != -1:
                    mini = min(mini, array[i-1])
                    maxi = max(maxi, array[i-1])
            if i+1 < n:
                if array[i+1] != -1:
                    mini = min(mini, array[i+1])
                    maxi = max(maxi, array[i+1])
    ans = (mini + maxi)//2
    for i in range(n):
        if array[i] == -1:
            array[i] = ans
    this = -1
    for i in range(n-1):
        this = max(this, abs(array[i]-array[i+1]))
    ans = [this, ans]
    print(*ans)