import atexit
import io
import sys

_INPUT_LINES = sys.stdin.read().splitlines()
input = iter(_INPUT_LINES).__next__
_OUTPUT_BUFFER = io.StringIO()
sys.stdout = _OUTPUT_BUFFER


@atexit.register
def write():
    sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())


def MSB(n):
    ndx = 0
    while n > 1:
        n = (n >> 1)
        ndx += 1

    return ndx


def main():
    n, q = map(int, input().split())

    bits = [0] * 32
    arr = list(map(int, input().split()))

    for v in arr:
        bits[MSB(v)] += 1

    for i in range(q):
        v = int(input())
        cnt = 0
        for p in range(31, -1, -1):
            if bits[p] > 0:
                if (1 << p) <= v:
                    needed = v // (1 << p)
                    take = min(needed, bits[p])
                    cnt += take
                    v -= take * (1 << p)
        if v != 0:
            print(-1)
        else:
            print(cnt)


if __name__ == "__main__":
    main()
