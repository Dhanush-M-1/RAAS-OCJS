import sys
import math
import time
def ms_time():
    return int(round(time.time() * 1000))


runtime = ms_time()

def factors(n):
    for d in range(2, math.ceil(n) + 1):
        if ms_time() - runtime > 100:
            print(2)
            sys.exit(0)

        if n % d == 0:
            yield d

def main():
    lines = list(map(str.strip, sys.stdin.readlines()))

    l, r = map(int, lines[0].split())

    if l == r:
        print(l)
        sys.exit(0)


    divs = {}

    for n in range(l, r+1):
        for d in factors(n):
            if d not in divs:
                divs[d] = 0
            divs[d] += 1

    _, d = max((count, div) for div, count in divs.items())
    print(d)


if __name__ == "__main__":
    main()
