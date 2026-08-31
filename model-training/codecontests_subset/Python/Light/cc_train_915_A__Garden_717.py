# @author Matheus Alves dos Santos

n_buckets, length = map(int, input().split())
buckets = list(map(int, input().split()))
buckets.sort(reverse = True)


for i in buckets:
    if (length % i == 0):
        print(length // i)
        break
