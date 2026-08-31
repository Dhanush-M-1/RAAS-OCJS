import sys

def max_even(arr):
    index = -1
    for i in range(len(arr)):
        if(arr[i] % 2 == 0):
            return i
    return index


def max_not_even(arr):
    index = -1
    for i in range(len(arr)):
        if(arr[i] % 2 == 1):
            return i
    return index

size = int(input())

arr = sorted(list(map(int, input().split(' '))))
arr.reverse()



res = sys.maxsize
for start in (True, False):
    tmp = arr[:]
    while True:
        if start:
            even = max_even(tmp)
            if even == -1:
                break
            del tmp[even]
        if not start:
            not_even = max_not_even(tmp)
            if not_even == -1:
                break
            del tmp[not_even]
        start = not start
    if res > sum(tmp):
        res = sum(tmp)
print(res)