'''input
6
1 4 3 3 5 7
3 7 5 4 3
4 3 7 5
'''
from collections import Counter
n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))

c1, c2, c3 = Counter(a), Counter(b), Counter(c)
print(list((c1-c2).elements())[0], list((c2-c3).elements())[0], sep='\n')
