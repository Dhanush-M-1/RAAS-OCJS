n = int(input())
first = [int(n) for n in input().split()]
second = [int(n) for n in input().split()]
third = [int(n) for n in input().split()]

print(sum(first) - sum(second))
print(sum(second) - sum(third))