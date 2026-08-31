n = input()

errors1 = list(map(int, input().split()))
errors2 = list(map(int, input().split()))
errors3 = list(map(int, input().split()))

errors1 = sum(errors1)
errors2 = sum(errors2)
errors3 = sum(errors3)

print(errors1 - errors2)
print(errors2 - errors3)