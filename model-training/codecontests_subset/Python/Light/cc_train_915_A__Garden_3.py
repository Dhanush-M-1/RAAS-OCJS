n, k = map(int, input().split())
print(k // max(filter(lambda x: k % x == 0, map(int, input().split()))))
