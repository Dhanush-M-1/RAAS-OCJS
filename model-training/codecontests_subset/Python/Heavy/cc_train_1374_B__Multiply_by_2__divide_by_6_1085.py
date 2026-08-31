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

def submit():
    for _ in range(int(input())):
        n = int(input())
        print(algorithm(n))

def tryOut():
    #start_time = time()
    print(algorithm(a))
    #print(f"Execution time: {time() - start_time}s")

#a = 387420489
#tryOut()
submit()