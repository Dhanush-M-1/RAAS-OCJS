input()
first = [int(i) for i in input().split()]
second = [int(i) for i in input().split()]
third = [int(i) for i in input().split()]
a = sum(first) - sum(second)
b = sum(second) - sum(third)
print(a)
print(b)