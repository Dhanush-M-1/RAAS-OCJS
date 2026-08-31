
def phantichsonguyento(n):
    result = []
    for i in range(2,n):
        dem = 0
        while True:
            if n % i != 0:
                break
            else:
                dem += 1
                n //= i
        if dem:
            if dem > 1:
                for j in range(dem):
                    result.append(i)
            else:
                result.append(i)
    return result
from math import *
if __name__ == '__main__':
    n = int(input().strip())
    # print(phantichsonguyento(n))
    for i in range(int(sqrt(n)),0,-1):
        if n % i == 0 and gcd(n//i,i) == 1:
            print(i,n//i)
            break