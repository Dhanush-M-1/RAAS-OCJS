n = int(input())
a = [int(i) for i in input().split()]
b = [int(i) for i in input().split()]
c = [int(i) for i in input().split()]

print(sum(a) - sum(b))
print(sum(b) - sum(c))