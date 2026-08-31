def seal(a, b):
    return (a + b - 1)//b
for _ in range(int(input())):
    n = int(input())
    r = [int(x) for x in input().split()]
    c = [int(x) for x in input().split()]
    arr = [[r[i],c[i]] for i in range(n)]
    arr.sort()
    ans = 0
    if(arr[0] != [1,1]):
        arr.insert(0,[1,1])
    n = len(arr)
    prev = [1,1]
    for i in range(1,n):
        # Odd
        curr = arr[i]
        if(sum(prev) & 1):
            if((curr[0] - prev[0]) & 1):
                ans += seal(curr[0] - prev[0], 2) - seal(curr[1] - prev[1], 2)
            else:
                ans += seal(curr[0] - prev[0], 2) - ((curr[1] - prev[1])>>1)
        else:
            # Diagonal
            if(curr[0] - prev[0] == curr[1] - prev[1]):
                ans += curr[0] - prev[0]
            else:
                if((curr[0] - prev[0]) & 1):
                    ans += ((curr[0] - prev[0])>>1) - ((curr[1] - prev[1])>>1)
                else:
                    ans += ((curr[0] - prev[0])>>1) - seal(curr[1] - prev[1], 2)
        prev = curr

    print(ans)