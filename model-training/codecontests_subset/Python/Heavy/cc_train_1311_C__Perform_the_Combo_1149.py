
import collections


def solve(n, m, s, p):
    prefixSums = [0 for _ in range(n)]

    for elem in p:
        prefixSums[elem-1] += 1

    prefixSums[n-1] = 1

    for i in range(n-2, -1, -1):
        prefixSums[i] += prefixSums[i+1]

    counts = [0 for _ in range(26)]

    for i, sum in enumerate(prefixSums):
        counts[ord(s[i]) - ord('a')] += sum

    return " ".join(map(str, counts))


t = int(input().strip())
# [n,m] = list(map(int, input().strip().split()))

for i in range(t):
    [n, m] = list(map(int, input().strip().split()))

    s = input().strip()

    p = list(map(int, input().strip().split()))

    print(solve(n, m, s, p))
