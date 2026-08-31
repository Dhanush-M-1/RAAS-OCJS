from collections import Counter
n = int(input())
s1 = Counter(map(int, input().split()))
s2 = Counter(map(int, input().split()))
s3 = Counter(map(int, input().split()))
r1 = list(s1 - s2)
r2 = list(s2 - s3)
print(r1[0])
print(r2[0])
