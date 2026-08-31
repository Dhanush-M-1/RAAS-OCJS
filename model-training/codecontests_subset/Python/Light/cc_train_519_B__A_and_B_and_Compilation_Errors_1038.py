n = int(input())
l1 = input().split()
l2 = input().split()
l3 = input().split()
a = 0
b = 0
c = 0

for i in l1:
    a += int(i)

for i in l2:
    b += int(i)

for i in l3:
    c += int(i)

print(a-b)
print(b-c)