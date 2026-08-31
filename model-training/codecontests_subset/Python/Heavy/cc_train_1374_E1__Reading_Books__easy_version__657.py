# import sys
# sys.stdin = open("test.txt", 'r')

n, k = list(map(int, input().split()))

times = [[], [], [], []]
for _ in range(n):
    t, a, b = list(map(int, input().split()))
    times[2*a + b].append(t)

for i in range(1, 4):
    times[i] = sorted(times[i][:])

prefix_sums = [[], [], [], []]
for i in range(1, 4):
    prefix_sums[i].append(0)
    for v in times[i]:
        prefix_sums[i].append(prefix_sums[i][-1] + v)

mint = 2e9+1
for i in range(min(k+1, len(prefix_sums[3]))):
    needs = k - i
    if len(prefix_sums[1]) > needs and len(prefix_sums[2]) > needs:
        mint = min(mint, prefix_sums[3][i] + prefix_sums[1][needs] + prefix_sums[2][needs])

if mint == 2e9+1: mint = -1
print(mint)
