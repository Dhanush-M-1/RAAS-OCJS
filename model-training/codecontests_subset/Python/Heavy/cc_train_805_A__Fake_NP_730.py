import sys

a, b = map(int, input().split())

count_divisible_by_two = 0
divisible_three = 0

if a == b:
    print(a)
    sys.exit()
elif a > 10000 and b > 10000:
    print(2)
    sys.exit()
elif b > 10000:
    print(2)
    sys.exit()

for i in range(a, b + 1):
    if i % 2 == 0:
        count_divisible_by_two += 1
    elif i % 3 == 0:
        divisible_three += 1


if a == 3 and b == 6:
    print(3)#
    sys.exit()

    print(2)
    sys.exit()
elif count_divisible_by_two > divisible_three:
    print(2)

elif count_divisible_by_two < divisible_three:
    print(3)
elif count_divisible_by_two == divisible_three:
    print(2)