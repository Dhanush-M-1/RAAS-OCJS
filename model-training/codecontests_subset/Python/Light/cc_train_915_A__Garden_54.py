n, length = map(int, input().split())
buckets = list(map(int, input().split()))
hours = float("inf")
for b in buckets:
    if length % b == 0:
        hours = min(hours, length // b)
print(hours)
