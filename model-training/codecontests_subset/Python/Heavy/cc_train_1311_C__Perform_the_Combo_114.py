from collections import defaultdict
from time import time


alphabet = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z']

N = int(input())


for _ in range(N):
    n, m = map(int, input().split())
    ss = input()
    ps = list(map(int, input().split()))

    count = defaultdict(int)
    p_count = [0] * n

    for p in ps:
        p_count[p-1] += 1

    for i in range(n-1, 0, -1):
        p_count[i-1] += p_count[i]

    ans = [0] * 26
    for i in range(n):
        ans[alphabet.index(ss[i])] += p_count[i] + 1

    print(*ans)



