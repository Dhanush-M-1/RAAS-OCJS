import sys
from functools import lru_cache
from collections import defaultdict

@lru_cache(maxsize=None)
def find_min(i, space):
    if i == len(mat):
        # Nothing to fell.
        return 0
    elif i == len(mat) - 1:
        # Just fell to the right.
        return 1

    # We have at least one tree.
    # Options left, right, Nothing.
    pos, h = mat[i]
    if pos - h > space:
        return 1 + find_min(i + 1, pos)
    else:
        # Drop to the right if you can.
        if pos + h < mat[i + 1][0]:
            n = 1 + find_min(i + 1, pos + h)
        else:
            n = find_min(i + 1, pos)
        return n

def iterate(arr):
    left = -float("inf")
    s = 1
    for i in range(len(arr) - 1):
        pos, h = arr[i]
        n_pos = arr[i + 1][0]
        
        if pos - h > left:
            s += 1
            left = pos
        elif pos + h < n_pos:
            left = pos + h
            s += 1
        else:
            left = pos
    return s

if __name__ == "__main__":
    mat = []
    for e, line in enumerate(sys.stdin.readlines()):
        if e == 0:
            continue
        mat.append(list(map(int, line.strip().split())))
    print(iterate(mat))
