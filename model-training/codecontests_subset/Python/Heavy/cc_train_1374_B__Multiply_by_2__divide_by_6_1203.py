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

def factor(n):
    res = []
    d = 2
    while d * d <= n:
        if n % d == 0:
            res.append(d)
            n //= d
        else:
            d += 1
        if d > 3:
            raise ValueError
    if n > 1:
        if n > 3:
            raise ValueError
        res.append(n)
    return res

def solve(n):
    try:
        f = factor(n)
    except ValueError:
        return -1
    s3 = f.count(3)
    s2 = f.count(2)
    if s3 < s2:
        return -1
    s3 = s3 - s2
    return 2 * s3 + s2


counts = int(input())

for i in range(counts):
    n = int(input())
    print(solve(n)) 