from collections import Counter
from math import gcd
from functools import reduce

if __name__ == '__main__':
    k = int(input())
    s = input()
    if k == 1:
        print(s)
        exit(0)
    counts = Counter(s)
    if any(v % k != 0 for v in counts.values()):
        print(-1)
        exit(0)

    new_string = []
    for letter in counts:
        for _ in range(counts[letter] // k):
            new_string.append(letter)
    new_string = ''.join(new_string)
    print(''.join(new_string for _ in range(k)))