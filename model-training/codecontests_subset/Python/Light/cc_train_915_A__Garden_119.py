n, k = map(int,input().split())
a = list(map(int,input().split()))
print(k // max(i for i in a if k % i == 0))