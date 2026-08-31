from sys import stdin

n, k = [int(i) for i in stdin.readline().strip().split()]
a = [int(i) for i in stdin.readline().strip().split()]


p = [19 * [0] for _ in range(max(a) + 1)]


nums = set()
for m in a:
    for i in range(19):
        p[m >> i][i] += 1
        nums.add(m >> i)

        if (m >> i) == 0:
            break

res = 10000000000000000000

for m in nums:
    d = p[m]
    sum = 0
    steps = 0
    for i in range(19):
        if sum + d[i] >= k:
            add = (k - sum) * i
            steps += add
            res = min(steps, res)
            break
        else:
            sum += d[i]
            steps += (i * d[i])

print(res)
