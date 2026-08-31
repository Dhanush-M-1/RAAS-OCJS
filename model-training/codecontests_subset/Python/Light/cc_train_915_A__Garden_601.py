n,k = map(int,input().split())
arr = list(map(int,input().split()))
arr.sort()
for item in arr:
    if k/item == k//item:
        mn = k//item
print(mn)
