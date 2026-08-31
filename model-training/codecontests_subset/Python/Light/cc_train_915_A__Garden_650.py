size, leng = map(int, input().split())
arr = list(map(int, (input().split())))
arr.sort()
for i in reversed(arr):
    if leng % i == 0:
        print(leng // i)
        exit(0)

