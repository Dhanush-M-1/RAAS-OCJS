n = int(input())
prizes = list(map(int, input().split(" ")))
maxDistance = -1
for i in prizes:
    maxDistance = max(maxDistance, min(10**6 - i, i - 1))
print(maxDistance)