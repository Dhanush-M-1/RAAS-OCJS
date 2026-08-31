n = int(input())
a = [int(x) for x in input().split()]
b = [int(x) for x in input().split()]
c = [int(x) for x in input().split()]

a = sum(a)
b = sum(b)
c = sum(c)

print(a-b)
print(b-c)
