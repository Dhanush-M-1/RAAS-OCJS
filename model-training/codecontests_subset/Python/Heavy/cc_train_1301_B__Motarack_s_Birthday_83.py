def run_length_compress(string):
    string.append("@")
    n = len(string)

    begin = 0
    end = 1
    cnt = 1
    ans = []
    while True:
        if end >= n:
            break
        if string[begin] == string[end]:
            end += 1
            cnt += 1
        else:
            ans.append(string[begin])
            begin = end
            end = begin + 1
            cnt = 1

    return ans

import sys
input = sys.stdin.readline

t = int(input())
INF= 10**18
for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    max_a = 0
    min_a = INF
    adj = 0
    b = run_length_compress(a)
    for i, num in enumerate(b):
        if b[i] == -1:
            if i - 1 >= 0:
                if b[i - 1] != -1:
                    min_a = min(min_a, b[i - 1])
                    max_a = max(max_a, b[i - 1])
            if i + 1 < len(b):
                if b[i + 1] != -1:
                    min_a = min(min_a, b[i + 1])
                    max_a = max(max_a, b[i + 1])
        else:
            if i - 1 >= 0:
                if b[i - 1] != -1:
                    adj = max(adj, abs(b[i - 1] - b[i]))
            if i + 1 < len(b):
                if b[i + 1] != -1:
                    adj = max(adj, abs(b[i + 1] - b[i]))
    if min_a == INF:
        print(0, 0)
    else:
        print(max(adj, (max_a + 1 - min_a) // 2), min_a + (max_a + 1 - min_a) // 2)