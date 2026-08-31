from math import *


def relative(a, b):
    if a == b and a != 1:
        return False
    elif a == b:
        return True
    for num in range(2, int(sqrt(max(a, b))) + 1):
        if a % num == 0 and b % num == 0:
            return False
    return True


inp = int(input())
middle = int(sqrt(inp))
counter = middle
break1 = False
while counter > 0 and not break1:
    if inp % counter == 0:
        temp = inp / counter
        if relative(counter, temp):
            print(int(counter), int(temp))
            break1 = True
            break
    counter = counter - 1

