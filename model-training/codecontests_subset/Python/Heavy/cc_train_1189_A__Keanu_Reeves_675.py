# https://codeforces.com/problemset/problem/1189/A
from sys import stdin
from typing import List


def are_zeroes_and_ones_equal(s: str) -> bool:
    count_zeroes = len([z for z in s if z == "0"])
    count_ones = len([o for o in s if o == "1"])
    return count_zeroes == count_ones


def split(remaining: str, completed: List[str] = []) -> List[str]:
    if not remaining:
        return completed
    end = len(remaining)
    while are_zeroes_and_ones_equal(remaining[:end]):
        end -= 1
    return split(remaining[end:], completed + [remaining[:end]])


if __name__ == "__main__":
    stdin.readline()
    input_str = stdin.readline().strip()
    result = split(input_str)
    print(len(result))
    print(" ".join(result))
