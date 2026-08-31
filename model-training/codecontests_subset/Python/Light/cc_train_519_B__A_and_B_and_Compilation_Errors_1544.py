
num_of_errors = int(input())
first, second, third = [sum([int(i) for i in input().split()]) for i in range(3)]

print(first - second)
print(second - third)