input()
a = input().split()
s = input().split()
d = input().split()
sum_a = 0
sum_s = 0
sum_d = 0
for i in a:
    sum_a += int(i)
for i in s:
    sum_s += int(i)
for i in d:
    sum_d += int(i)
print(sum_a - sum_s)
print(sum_s - sum_d)
