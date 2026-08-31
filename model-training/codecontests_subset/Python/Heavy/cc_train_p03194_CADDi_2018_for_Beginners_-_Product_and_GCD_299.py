import math
if __name__ == "__main__":
    n, p = map(int, input().split())
    if n == 1:
        print(p)
    else:
        res = 1
        sup = math.ceil(p ** (1 / n))
        i = 2
        while(i <= sup and i <= p):
            if p % i == 0:
                k = 1
                p /= i
                while(p % i == 0):
                    p /= i
                    k += 1
                if k >= n:
                    for s in range(k // n):
                        res *= i
            i += 1
        print(res)