from time import time
from random import randint

def algorithm(n):
    operations = 0
    while (n > 1):
        if n%3 != 0:
            return -1
        if n%6 == 0:
            n //= 6
        else:
            n *= 2
        operations += 1
    return operations

def algorithm2(n):
    cnt2 = cnt3 = 0
    while (n % 2 == 0):
        n //= 2
        cnt2 += 1
    while (n%3 == 0):
        n //= 3
        cnt3 += 1
    if (n == 1 and cnt2 <= cnt3):
        return (2*cnt3 - cnt2)
    else:
        return (-1)


def submit():
    for _ in range(int(input())):
        n = int(input())
        print(algorithm2(n))

def tryOut():
    #start_time = time()
    print(algorithm2(a))
    #print(f"Execution time: {time() - start_time}s")

a = 6
#tryOut()
submit()