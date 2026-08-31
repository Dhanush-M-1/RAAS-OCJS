buckets, length = map(int,input().split())
data = list(map(int,input().split()))
data.sort(reverse=True)
for element in data:
    if length % element == 0:
        print(length // element)
        break