import sys
import io

stream_enable = 0

inpstream = """
7 1
101 53 42 102 101 55 54 101 101 102
"""

if stream_enable:
    sys.stdin = io.StringIO(inpstream)
    input()

def inpmap():
    return list(map(int, input().split()))

n, k = inpmap()
arr = inpmap()
arr.sort()
# print(arr)
i = 1
x = 1
while i < len(arr):
    if arr[i] == arr[i - 1]:
        x += 1
    elif arr[i] > arr[i - 1] and arr[i] <= arr[i - 1] + k:
        n -= x
        x = 1
        # x = arr[i - 1] == arr[i - 2]
        # arr.pop(i - 1)
        # if x:
        #     i -= 1
    else:
        x = 1
    # else:
    i += 1
    # print(arr)
print(n)
