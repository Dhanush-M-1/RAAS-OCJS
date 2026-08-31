from collections import Counter
n, m = list(map(int, input().split()))

a = list(map(int, input().split()))
b = list(map(int, input().split()))

for i in range(len(b)):
    b[i] = b[i] % m
    
for i in range(len(a)):
    a[i] = a[i] % m

b = sorted(b)
a = sorted(a)
# print('a', a, 'b', b)
counterb = Counter(b)
temp = a[:]

for i in range(len(temp)):
    temp[i] = (m + b[0] - a[i]) % m
temp = list(set(sorted(temp)))

# print('temp', temp)
for x in temp:
#     print('x', x, 'a', a)
    newa = [(i + x) % m for i in a]
#     print('newa', newa)
    countera = Counter(newa)
#     print(newa, countera, counterb)
    if countera == counterb:
        print(x)
        break
