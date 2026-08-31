from collections import Counter
import string


def sort(s):
    counter = Counter(s)
    res = list()
    for char in string.ascii_uppercase:
        res.extend([char] * counter[char])
    return ''.join(res)


n = int(input())

for _ in range(n):

    s_str, c_str = input().split()
    s, c = list(s_str), list(c_str)
    arranged = sort(s)

    idx = -1
    while idx + 1 < len(s) and s[idx + 1] == arranged[idx + 1]:
        idx += 1

    idx += 1

    if idx < len(s):
        last_idx = s_str.rindex(arranged[idx])
        s[idx], s[last_idx] = s[last_idx], s[idx]

    if ''.join(s) < ''.join(c):
        print(''.join(s))
    else:
        print("---")
