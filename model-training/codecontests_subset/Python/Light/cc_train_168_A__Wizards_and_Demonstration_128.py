import math

if __name__ == '__main__':
    n, x, y = str(input()).split()
    n = int(n)
    x = int(x)
    y = int(y)
    print(max(0, int(math.ceil(n * y / 100)) - x))
