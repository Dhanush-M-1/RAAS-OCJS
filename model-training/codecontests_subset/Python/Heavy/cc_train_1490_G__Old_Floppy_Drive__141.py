import bisect
from collections import defaultdict
t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    arr = [int(i) for i in input().split()]
    ops = [int(i) for i in input().split()]
    prefix_sum = [0 for i in range(n)]
    prefix_sum[0] = arr[0]
    for i in range(1, n):
        prefix_sum[i] = prefix_sum[i - 1] + arr[i]

    prefix_pos = []
    prefix_min_index = defaultdict(int)
    for i in range(n):
        if prefix_sum[i] > 0:
            prefix_pos.append((prefix_sum[i],i))
    prefix_pos.sort()
    for i in range(len(prefix_pos) - 1,-1, -1):
        if i < len(prefix_pos) - 1:
            prefix_min_index[prefix_pos[i][0]] = min(prefix_pos[i][1], prefix_min_index[prefix_pos[i + 1][0]])
        else:
            prefix_min_index[prefix_pos[i][0]] = prefix_pos[i][1]

    ans = []

    for i in range(m):
        tar = ops[i]
        if len(prefix_pos) <= 0:
            ans.append(-1)
            continue
        need = tar - prefix_pos[-1][0]
        if need <= 0:
            res = bisect.bisect_left(prefix_pos,(tar,0))
            amount = prefix_pos[res][0]
            ans.append(prefix_min_index[amount])
        else:
            if prefix_sum[-1] <= 0:
                ans.append(-1)
                continue
            else:
                times = need // prefix_sum[-1]
                if need%prefix_sum[-1] != 0:
                    times += 1
                need = tar - (times * prefix_sum[-1])
                res = bisect.bisect_left(prefix_pos,(need,0))
                amount = prefix_pos[res][0]
                cost = times*n
                ans.append(cost + prefix_min_index[amount])
    print(' '.join(str(i) for i in ans))
