ans1 = input()
n, k = list(map(int, ans1.split()))
ans2 = input()
buckets = list(map(int, ans2.split()))

bestHours = 0
for a in buckets:
    if (k/a < bestHours or bestHours == 0) and k % a == 0:
        bestHours = k//a

print(bestHours)