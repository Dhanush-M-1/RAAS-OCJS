n, k = map(int, input().split())
print(int(k / max(x for x in list(map(int, input().split())) if not k % x)))
