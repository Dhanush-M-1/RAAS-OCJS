# Multiset Problem?
from collections import Counter
IC = lambda: Counter(map(int, input().split()))
n = int(input())
a,b,c = (IC() for _ in range(3))
print((a-b).popitem()[0])
print((b-c).popitem()[0])