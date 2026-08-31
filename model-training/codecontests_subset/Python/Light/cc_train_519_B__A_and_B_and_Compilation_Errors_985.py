n = int(input())
a = [int(i) for i in input().split()]
b = [int(i) for i in input().split()]
c = [int(i) for i in input().split()]
f1 = 0
f2 = 0
f3 = 0
for i in a:
    f1 += i 
for i in b:
    f2 += i 
for i in c:
    f3 += i
print(f1-f2)
print(f2-f3)