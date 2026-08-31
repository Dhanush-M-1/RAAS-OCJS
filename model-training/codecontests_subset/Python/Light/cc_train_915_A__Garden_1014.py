n, k = map(int, input().split())
a = list(map(int, input().split()))

print(min(map(lambda ai: k // ai, filter(lambda ai: k % ai == 0, a))))
