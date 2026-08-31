import sys
options = []
[n, k] = list(map(int, sys.stdin.readline().strip().split(' ')))
buckets = list(map(int, sys.stdin.readline().strip().split(' ')))
for i in range(len(buckets)):
  if (k % buckets[i] == 0):
    options.append(buckets[i])

print(k//max(options))