from collections import Counter
n = int(input())
a = Counter(int(x) for x in input().split())
b = Counter(int(x) for x in input().split())
c = Counter(int(x) for x in input().split())
print((a - b).most_common(1)[0][0])
print((b - c).most_common(1)[0][0])
