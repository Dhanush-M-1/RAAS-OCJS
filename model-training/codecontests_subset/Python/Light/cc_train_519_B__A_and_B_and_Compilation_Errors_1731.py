n=int(input())
li1 = list(map(int, input().split()))
li2 = list(map(int, input().split()))
li3 = list(map(int, input().split()))
from collections import Counter
c1 = Counter(li1)
c2 = Counter(li2)
c3 = Counter(li3)
diff1 = c1-c2
diff2 = c2-c3
d1=list(diff1.elements())
d2=list(diff2.elements())
print(*d1, sep = " ")
print(*d2, sep = " ")