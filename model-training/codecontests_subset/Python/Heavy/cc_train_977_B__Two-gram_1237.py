"""
https://codeforces.com/problemset/problem/977/B

Two-gram is an ordered pair (i.e. string of length two) of capital Latin letters. For example, "AZ", "AA", "ZA" — three distinct two-grams.

You are given a string s
consisting of n capital Latin letters. Your task is to find any two-gram contained in the given string as a substring (i.e. two consecutive characters of the string) maximal number of times. For example, for string s = "BBAABBBA" the answer is two-gram "BB", which contained in s three times. In other words, find any most frequent two-gram.
"""

"""
Accepted
Time Complexity :
Space Complexity :
Solution Explantion :
"""
from sys import stdin, stdout


def mode_two_gram(n: int, latin: str) -> str:
    histogram = {}
    for i in range(n - 1):
        two_gram = latin[i] + latin[i + 1]
        if not two_gram in histogram:
            histogram[two_gram] = 1
        else:
            histogram[two_gram] += 1

    return max(histogram, key=lambda k: histogram[k])


if __name__ == "__main__":
    n = int(stdin.readline().rstrip())
    latin = stdin.readline().rstrip()
    stdout.write(mode_two_gram(n, latin) + "\n")
