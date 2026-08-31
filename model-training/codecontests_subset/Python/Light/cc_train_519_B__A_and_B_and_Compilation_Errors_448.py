n = int(input())

a = [int(t) for t in input().split()]
b = [int(t) for t in input().split()]
c = [int(t) for t in input().split()]

error1 = 0
for e in a+b:
    error1 ^= e

error2 = 0
for e in b+c:
    error2 ^= e

print(error1)
print(error2)