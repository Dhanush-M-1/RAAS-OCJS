#B. A and B and Compilation Errors

n = int(input())
a = [int(x) for x in input().split(' ')]
b = [int(x) for x in input().split(' ')]
c = [int(x) for x in input().split(' ')]

suma = 0
sumb = 0
sumc = 0

for i in a:
    suma += i
for i in b:
    sumb += i
for i in c:
    sumc += i
print(suma - sumb)
print(sumb - sumc)
