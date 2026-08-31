n = int(input())
a = list(map(int, input().split())) 
b = list(map(int, input().split()))
c = list(map(int, input().split()))
from collections import Counter
c1 = Counter(a)
c2 = Counter(b)
c3 = Counter(c)
diff1 = c1-c2
diff2 = c2-c3
print(*list(diff1.elements()))
print(*list(diff2.elements()))
        
