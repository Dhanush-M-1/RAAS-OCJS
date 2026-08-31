# https://codeforces.com/problemset/problem/219/A

"""
k-string is something that can be represented as k concatenated copies of some string

Given a string of lowercase english letters, reorder the letters such that the string is a k string
"""

import sys


def main():
    k = int(sys.stdin.readline())
    s = sys.stdin.readline().strip()

    letter_count = {}

    for letter in s:
        letter_count[letter] = letter_count.get(letter, 0) + 1

    schema = []
    for letter in letter_count:
        if (letter_count[letter] / k) % 1 == 0:
            schema.append((letter, letter_count[letter] // k))
        else:
            return '-1'

    repeat = ''
    for scheme in schema:
        letter, quantity = scheme
        repeat += letter*quantity

    return repeat * k


if __name__ == '__main__':
    sys.stdout.write(main())