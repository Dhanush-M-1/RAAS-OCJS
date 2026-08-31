n, k = map(int, input().split())
row = list(map(int, input().split()))
b = max(x for x in row if k % x == 0)
print(k // b)
