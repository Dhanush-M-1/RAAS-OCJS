n = int(input())
print(max([int(500000.5 - abs(500000.5 - x) - 1) for x in [int(i) for i in input().split(' ')]]))