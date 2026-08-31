n = int(input())
a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]
c = [int(x) for x in input().split()]

sumA = sum(a)
sumB = sum(b)
sumC = sum(c)

print(sumA - sumB)
print(sumB - sumC)