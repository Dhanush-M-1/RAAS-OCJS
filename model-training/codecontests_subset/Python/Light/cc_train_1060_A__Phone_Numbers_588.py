n = int(input())
a = input()
k = 0
kk = 0
for x in a:
    if x == '8':
        k += 1
while n >= 11 and k:
    k -= 1
    n -= 11
    kk += 1
print(kk)