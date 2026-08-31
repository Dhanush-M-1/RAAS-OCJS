from collections import Counter


n, a, b, c = [Counter(input().split()) for _ in range(4)]
print((a - b).popitem()[0])
print((b - c).popitem()[0])
