

number_of_buckets, length = map(int, input().split(' '))
buckets = list(map(int, input().split(' ')))

buckets = sorted(buckets, reverse=True)
for i in range(0, len(buckets)):
    if length% buckets[i] == 0:
        print(length // buckets[i])
        break