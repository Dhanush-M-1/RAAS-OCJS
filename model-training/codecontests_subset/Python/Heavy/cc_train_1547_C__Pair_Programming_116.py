cases = int(input())
for _ in range(cases):
    input()
    k, n, m = map(int, input().split())
    arr1 = list(map(int, input().split()))[::-1]
    arr2 = list(map(int, input().split()))[::-1]

    ans = []
    cur_line = k
    for i in range(n+m):
        if arr1 and arr2:
            if arr1[-1] <= arr2[-1]:
                last = arr1.pop()
            else:
                last = arr2.pop()
        elif arr1:
            last = arr1.pop()
        elif arr2:
            last = arr2.pop()
        if last > cur_line:
            print(-1)
            break
        if last == 0:
            cur_line += 1
        ans.append(last)
    else:
        print(*ans)