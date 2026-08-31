n, k = list(map(int, input().split()))
buckets = reversed(sorted(list(map(int, input().split()))))

for i in buckets:
    if k % i == 0:
        print(k // i)
        exit()