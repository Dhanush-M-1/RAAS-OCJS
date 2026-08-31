from collections import Counter
n = input()
set1 = Counter(input().split())
set2 = Counter(input().split())
set3 = Counter(input().split())
print(list(set1 - set2)[0])
print(list(set2 - set3)[0])