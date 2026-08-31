n, k = list(map(int,input().split()))
a = list(map(int,input().split()))
a = [item for item in a if k % item == 0]
print(k//max(a))


