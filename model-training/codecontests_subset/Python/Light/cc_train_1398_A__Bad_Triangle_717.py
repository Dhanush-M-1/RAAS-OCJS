import bisect

t = int(input())
ans = []
for _ in range(t):
    n = int(input())
    A = list(map(int, input().split()))
    i = 0
    j = 1

    check_index = bisect.bisect_left(A, A[i] + A[j])

    if check_index >= n:
        ans.append([-1])
    else:
        k = check_index
        ans.append([i+1, j+1, k+1])
    
for a in ans:
    print(*a)