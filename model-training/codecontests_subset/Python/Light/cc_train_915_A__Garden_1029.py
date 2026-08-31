n, k = map(int, input().split())
print(k // max(filter(lambda v: k % v == 0, map(int, input().split()))))
