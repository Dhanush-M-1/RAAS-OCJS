n, k = map(int, input().split())
b = map(int, input().split())
print(min(k // x for x in b if k % x == 0))