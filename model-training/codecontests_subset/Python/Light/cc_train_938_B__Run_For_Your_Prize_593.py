from cmath import inf

n = int(input())
a = list(map(int, input().split()))

left = [0] + [x - 1 for x in a]
right = [10 ** 6 - x for x in a] + [0]

ans = inf
for i in range(n + 1):
    ans = min(ans, max(left[i], right[i]))

print(ans)
