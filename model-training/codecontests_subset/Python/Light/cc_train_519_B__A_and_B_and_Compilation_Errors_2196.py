n = int(input())
sums = [sum([int(x) for x in input().split()]) for i in range(3)]
print(sums[0] - sums[1])
print(sums[1] - sums[2])