import os

def g(xs, n):
    seen = [False] * n
    for i, x in enumerate(xs):
        j = (i + x) % n
        if seen[j]:
            return False
        else:
            seen[j] = True

    return True


def pp(input):
    n_test = int(input())
    for t in range(n_test):
        n = int(input())
        xs = map(int, input().split())
        if g(xs, n):
            print("YES")
        else:
            print("NO")

if "paalto" in os.getcwd():
    from string_source import string_source

    s1 = string_source(
        """6
1
14
2
1 -1
4
5 5 5 1
3
3 2 1
2
0 1
5
-239 -2 -100 -3 -11
"""
    )
    pp(s1)

else:
    pp(input)
