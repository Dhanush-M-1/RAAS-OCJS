n = int(input())
sum_1 = sum([int(s) for s in input().split()])
sum_2 = sum([int(s) for s in input().split()])
sum_3 = sum([int(s) for s in input().split()])

print(abs(sum_2 - sum_1))
print(abs(sum_3 - sum_2))
