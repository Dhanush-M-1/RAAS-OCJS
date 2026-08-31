n = int(input())

a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))

s_a = 0
s_b = 0
s_c = 0

for el in a:
    s_a += el

for el in b:
    s_b += el

for el in c:
    s_c += el

print(s_a - s_b)
print(s_b - s_c)