# import atexit
# import io
# import sys
#
# _INPUT_LINES = sys.stdin.read().splitlines()
# input = iter(_INPUT_LINES).__next__
# _OUTPUT_BUFFER = io.StringIO()
# sys.stdout = _OUTPUT_BUFFER
#
#
# @atexit.register
# def write():
#     sys.__stdout__.write(_OUTPUT_BUFFER.getvalue())


n = int(input())
arr = list(map(int, input().split()))

sm = sum(arr)
mx = max(arr)

if n * mx > sm * 2:
    print(mx)
else:
    for mxi in range(mx + 1, 202):
        if n * mxi > sm * 2:
            print(mxi)
            exit(0)
