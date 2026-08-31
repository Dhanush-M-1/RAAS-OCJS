#!/usr/bin/env python3

def solve(a, n):
    end_left_hill = 0
    while end_left_hill < n and a[end_left_hill] >= end_left_hill:
        end_left_hill += 1
    end_right_hill = n - 1
    while end_right_hill >= 0 and a[end_right_hill] >= (n - 1 - end_right_hill):
        end_right_hill -= 1

    end_right_hill += 1
    if end_right_hill >= end_left_hill:
        return False

    for i in range(end_right_hill, end_left_hill):
        if a[i] >= max([i, n - 1 - i]):
            return True

    return False

t = int(input())

for _ in range(t):
    n = int(input())
    a = list(map(int, input().split()))
    print("Yes" if solve(a, n) else "No")
