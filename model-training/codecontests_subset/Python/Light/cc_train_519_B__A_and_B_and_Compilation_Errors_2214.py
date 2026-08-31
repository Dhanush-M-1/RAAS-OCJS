n = int(input())
a = [int(i) for i in input().split()]
b = [int(i) for i in input().split()]
s = 0
for i in range(n-1):
    s ^= a[i]
    s ^= b[i]
s ^= a[-1]
print(s)
s = 0
a = [int(i) for i in input().split()]
for i in range(n-2):
    s ^= a[i]
    s ^= b[i]
s ^= b[-1]
print(s)
