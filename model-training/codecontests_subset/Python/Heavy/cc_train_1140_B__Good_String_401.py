"""
Code Forces Template
"""
import os
import sys
import string
import math


def solution(s):
    result = []
    if '>' in s:
        result.append(s.index('>'))
    if '<' in s:
        result.append(s[::-1].index('<'))
    return min(result)


def main(cases):
    """Algrithm"""
    for c in cases:
        print(solution(c))


def parse():
    """Load Input"""
    nums = int(input())
    cases = []
    for _ in range(nums):
        l = int(input())
        s = input()
        cases.append(s)
    return cases


if __name__ == '__main__':
    main(parse())
