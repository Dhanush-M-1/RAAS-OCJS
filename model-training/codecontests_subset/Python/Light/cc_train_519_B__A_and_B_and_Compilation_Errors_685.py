#!/usr/bin/env python3


def diff(list1, list2):
    for i in range(len(list2)):
        if list1[i] != list2[i]:
            return list1[i]
    return list1[-1]


n = int(input())
A = sorted(int(x) for x in input().split())
B = sorted(int(x) for x in input().split())
C = sorted(int(x) for x in input().split())
print(diff(A, B))
print(diff(B, C))
