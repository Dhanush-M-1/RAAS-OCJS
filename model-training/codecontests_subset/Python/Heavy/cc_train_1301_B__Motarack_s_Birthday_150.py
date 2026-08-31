#!/usr/bin/python3

def solve(n, arr):
    max_e = -1
    min_e = 10 ** 9
    max_d = 0
    for i in range(n):
        if arr[i] == -1:
            continue
        if i > 0 and arr[i-1] == -1 or i < n - 1 and arr[i+1] == -1:
            max_e = max(max_e, arr[i])
            min_e = min(min_e, arr[i])
    for i in range(n - 1):
        if arr[i] != -1 and arr[i + 1] != -1:
            max_d = max(max_d, abs(arr[i + 1] - arr[i]))

    if max_e == -1:
        min_e = max_e = 0

    k = (max_e + min_e) // 2
    m = max(max_d, (max_e - min_e + 1) // 2)
    return m, k

def main():
    t = int(input())
    for i in range(t):
        m, k =solve(int(input()), [int(e) for e in input().split()])
        print(m, k)

if __name__ == "__main__":
    main()