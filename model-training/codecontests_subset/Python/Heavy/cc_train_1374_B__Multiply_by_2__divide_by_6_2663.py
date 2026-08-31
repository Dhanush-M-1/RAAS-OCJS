import sys

for _ in range(int(sys.stdin.readline().rstrip())):
    n = int(sys.stdin.readline().rstrip())
    two = 0
    three = 0
    re = 0
    while True:
        if n == 1:
            break
        if n % 2 != 0 and n % 3 != 0:
            re = -1
            break
        if n % 3 == 0:
            n = int(n/3)
            three += 1
        elif n % 2 == 0:
            n = int(n/2)
            two += 1
    if re != -1:
        if two > three:
            re = -1
        else:
            re = (three - two) + three
    print(re)
