import io
import os
#input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

import math

def main():
    n, x, y = map(int, input().split())
    c = 0
    while math.floor((x+c)/n*100) < y:
        c += 1
    print(c)

if __name__ == '__main__':
    main()
