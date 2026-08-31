import sys

q = int(input())
for l, r, d in (map(int, l.split()) for l in sys.stdin):
    if l > d:
        print(d)
    else:
        ans = ((r+d-1) // d)*d
        print(ans if ans != r else ans+d)