n = int(input())
a = list(map(int, input().split()))
b = list(map(int, input().split()))
c = list(map(int, input().split()))
sumA = 0
for x in a:
    sumA += x
sumB = 0
for x in b:
    sumB += x
sumC = 0
for x in c:
    sumC += x
print(sumA - sumB)
print(sumB - sumC)