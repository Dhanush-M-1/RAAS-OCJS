import sys, collections, math
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def get_array(): return list(map(int, sys.stdin.readline().strip().split()))
def input(): return sys.stdin.readline().strip()
mod = 1000000007

for _ in range(int(input())):
    n = int(input())
    arr = get_array(); flag = False
    if (arr[0] + arr[1] > arr[n - 1]):
        if (arr[1] + arr[n - 1] > arr[0]):
            if (arr[n - 1] + arr[0] > arr[1]):
                print(-1)
            else:
                print(1, 2, n)
        else:
            print(1,2,n)
    else:
        print(1,2,n)