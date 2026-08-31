from collections import Counter

input()
s1 = Counter((int(x) for x in input().split()))
s2 = Counter((int(x) for x in input().split()))
s3 = Counter((int(x) for x in input().split()))

for k in s1 - s2:
    print(k)
for k in s2 - s3:
    print(k)
