#!/bin/python3

import sys

def solution(k ,buckets):
    buckets.sort(reverse=True)
    for b in buckets:
        if k % b == 0:
            return k // b

if __name__ == "__main__":
    n, k = input().strip().split(' ')
    n, k = [int(n), int(k)]
    buckets = list(map(int, input().strip().split(' ')))
    print(solution(k, buckets))
