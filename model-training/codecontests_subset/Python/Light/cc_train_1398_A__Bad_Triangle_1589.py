def multi_input():
    return map(int, input().split())

def array_print(arr):
    print(' '.join(map(str, arr)))

for i in range(int(input())):
    n = int(input())
    arr = list(multi_input())

    if arr[0] + arr[1] <= arr[-1]:
        print(1, 2, n)
    else:
        print(-1)