input()
n = input().split()
a = 0
for i in n:
    a+=int(i)
n = input().split()
b = 0
for i in n:
    b+=int(i)
print(a-b)
a = 0
n = input().split()
for i in n:
    a+=int(i)
print(b-a)