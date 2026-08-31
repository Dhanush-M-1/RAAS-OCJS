# Garden
def garden(k, arr):
    arr.sort(reverse=True)
    for i in arr:
        if k % i == 0:
            return k // i


n, k = list(map(int, input().split()))
arr = list(map(int, input().split()))
print(garden(k, arr))
