n = int(input())
a = [int(i) for i in input().split()]
c = []
k = 10 ** 6
m = 0
for el in a:
    m = max(min(el - 1, k - el), m)
print(m)