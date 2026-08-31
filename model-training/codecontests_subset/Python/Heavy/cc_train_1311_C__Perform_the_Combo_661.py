from string import ascii_lowercase
from collections import Counter


def read_ints():
    return [int(x) for x in input().split()]


for _ in range(int(input())):
    n, m = read_ints()
    s = input()
    p = [x - 1 for x in read_ints()]
    p.sort()
    letter_counts = Counter()
    string_counts = [1] * n
    j = m - 1
    for i in range(n-2, -1, -1):
        string_counts[i] = string_counts[i + 1]
        while j >= 0 and p[j] == i:
            string_counts[i] += 1
            j -= 1
    # print(string_counts)
    for i, count in enumerate(string_counts):
        letter_counts[s[i]] += count
    for ch in ascii_lowercase:
        print(letter_counts[ch], end=' ')
    print()
