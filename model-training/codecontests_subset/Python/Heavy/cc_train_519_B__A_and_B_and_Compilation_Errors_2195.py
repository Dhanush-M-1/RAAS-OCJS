import sys
import io
import os

total = 0
failed = 0
def debug(*args):
    if('LOCALTEST' in os.environ):
        print(*args, file=sys.stderr)
def run(test,res):
    x = io.StringIO()
    with io.StringIO(test) as sys.stdin:
        with x as sys.stdout:
            work()
            z = x.getvalue().strip()
    sys.stdout = sys.__stdout__
    print("Passed?", z == res)
    print("Expected: ", res)
    print("Actual  : ", z)
    global total, failed
    total  += 1
    failed += 1 if (z != res) else 0

def mm(l):
    s = {}
    for x in l:
        s[x] = 1 + (s[x] if x in s else 0)
    return s
def diff(a, b):
    debug(a)
    debug(b)
    ma = mm(a)
    mb = mm(b)
    debug(ma)
    debug(mb)
    debug(set(ma))
    debug(set(mb))
    d = set(mb)^set(ma)
    if len(d)==0:
        for x in set(ma):
            if ma[x]!=mb[x]:
                return x
    else:
        return list(d)[0]

def work():

    n = int(input())
    a = list(map(int, input().split()))
    b = list(map(int, input().split()))
    print(diff(a, b))
    c = list(map(int, input().split()))
    print(diff(b, c))

def test():
    run("""5
1 5 8 123 7 7
123 7 5 1 8 
8 5 1 7""", """7
123""")
    run("""5
1 5 8 123 7
123 7 5 1
5 1 7""", """8
123""")
    run("""6
1 4 3 3 5 7
3 7 5 4 3
4 3 7 5""", """1
3""")

if('LOCALTEST' in os.environ):
    test()
    print("\n Result: %s (%d total, %d failed)" % ("FAILED" if (failed>0) else "PASSED", total, failed))
else:
    work()
