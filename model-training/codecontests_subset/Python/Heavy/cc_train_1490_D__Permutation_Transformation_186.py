import math
import collections
import random


def read_list() -> list:
    return [int(i) for i in input().strip().split()]

def read_num() -> int:
    return int(input().strip())

def find(arr : list, ans : list, level : int):
    if arr == []:
        return
    if len(arr) == 1:
        ans[arr[0]] = level
    idx = arr.index(max(arr))
    ans[arr[idx]] = level
    find(arr[:idx], ans, level + 1)
    find(arr[idx + 1:], ans, level + 1)

t = read_num()
for i in range(t):
    n = read_num()
    arr = read_list()
    ans = [0] * (n + 5)
    find(arr, ans, 0)
    for i in arr:
        print(ans[i], end=" ")
    print()

