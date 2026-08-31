#code
from collections import Counter
n=int(input())
a=input().split()
b=input().split()
c=input().split()
c1 = Counter(a)
c2 = Counter(b)
c3 = Counter(c)
diff = c1-c2
diff1 = c2-c3
print(list(diff.elements())[0])
print(list(diff1.elements())[0])

