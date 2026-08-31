n = int(input())
a = [int(s) for s in input().split()]
b = [int(s) for s in input().split()]
c = [int(s) for s in input().split()]

print(sum(a) - sum(b))
print(sum(b) - sum(c))
