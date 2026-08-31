t = int(input())
for _ in range(t):
    n = int(input())
    ans = 'YES'
    for i in range(n):
        if i == 0:
            prev = tuple(map(int,input().split()))
            if prev[0] < prev[1]:
                ans = 'NO'
        else:
            cur = tuple(map(int,input().split()))
            if cur[1] < prev[1]:
                ans = 'NO'
            elif cur[0] < prev[0]:
                ans = 'NO'
            elif cur[1]-prev[1] > cur[0]-prev[0]:
                ans = 'NO'
            prev = cur
    print(ans)