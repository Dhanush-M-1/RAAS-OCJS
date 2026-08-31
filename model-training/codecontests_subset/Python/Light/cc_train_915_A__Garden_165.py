n, k = [int(i) for i in input().split()]
a = [int(i) for i in input().split()]

bucket = -1

for i in range(n):
    if not k % a[i]:
        bucket = max(bucket, a[i])
print(k // bucket)