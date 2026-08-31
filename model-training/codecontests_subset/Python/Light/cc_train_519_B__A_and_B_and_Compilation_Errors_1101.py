from collections import Counter
_ = input()
e1 = Counter(map(int, input().split()))
e2 = Counter(map(int, input().split()))
e3 = Counter(map(int, input().split()))
print (list(e1 - e2)[0])
print (list(e2 - e3)[0])