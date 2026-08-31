from collections import Counter
n = int(input())
c1 = Counter(list(map(int, input().split())))
c2 = Counter(list(map(int, input().split())))
c3 = Counter(list(map(int, input().split())))

diff = c1-c2
diff1 = c2-c3
a = list(diff.elements())
b = list(diff1.elements())
arr = [a[0], b[0]]
for i in arr:
    print(i)