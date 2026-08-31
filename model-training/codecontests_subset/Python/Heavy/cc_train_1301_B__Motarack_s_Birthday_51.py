import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)


############ ---- Input Functions ---- ############
def in_int():
    return (int(input()))


def in_list():
    return (list(map(int, input().split())))


def in_str():
    s = input()
    return (list(s[:len(s) - 1]))


def in_ints():
    return (map(int, input().split()))
t =  in_int()

while t > 0 :
    t-=1

    n = in_int()

    arr = in_list()
    mn = 10**9
    mx = -1
    for i in range(n):
        if i > 0 and arr[i] == -1 and arr[i - 1] != -1 :
            mn = min(mn, arr[i - 1])
            mx = max(mx, arr[i - 1])
        if i < n - 1 and arr[i] == - 1 and arr[i + 1] != -1:
            mn = min(mn, arr[i + 1])
            mx = max(mx, arr[i + 1])

    res = (mx + mn) // 2;
    ans = 0
    for i in range(n):
        if arr[i] == -1:
            arr[i] = res;
        if i >0:
            ans = max(ans, abs(arr[i] - arr[i - 1]))

    print( ans, res)

