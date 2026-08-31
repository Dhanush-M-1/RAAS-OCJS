

num = int(input())

first = [int(x) for x in input().strip().split(' ')]

second = [int(x) for x in input().strip().split(' ')]

last = [int(x) for x in input().strip().split(' ')]

sol1 = sum(first)-sum(second)
sol2 = sum(second)-sum(last)
print(sol1)
print(sol2)