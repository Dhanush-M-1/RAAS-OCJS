bucket_num, length = map(float, input().split())
buckets = list(map(int, input().split()))
buckets = sorted(buckets)
minimum_hours = 0
for bucket in buckets:
    if (length / bucket) % 1 == 0:
        minimum_hours = length // bucket
print(int(minimum_hours))