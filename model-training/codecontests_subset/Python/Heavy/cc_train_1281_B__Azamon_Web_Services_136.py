"""
https://codeforces.com/problemset/problem/1281/B
"""


def get_smallest(s, c):
    right_smallest = {}
    s = [i for i in s]
    right_smallest[len(s)-1] = s[-1], len(s)-1
    for i in range(len(s)-2, -1, -1):
        if s[i] > right_smallest[i+1][0]:
            right_smallest[i] = (right_smallest[i+1][0],
                                 right_smallest[i+1][1])
        else:
            right_smallest[i] = s[i], i

    if c.startswith("".join(s)) and len(s) < len(c):
        return "".join(s)

    for i in range(len(s)):
        if i >= len(c):
            return "---"
        if s[i] == c[i]:
            if right_smallest[i][0] < c[i]:
                better_index = right_smallest[i][1]
                s[i], s[better_index] = s[better_index], s[i]
                return "".join(s)
            else:
                continue
        elif s[i] < c[i]:
            return "".join(s)

        elif s[i] > c[i]:
            if right_smallest[i][0] < c[i]:
                better_index = right_smallest[i][1]
                s[i], s[better_index] = s[better_index], s[i]
                return "".join(s)
            elif right_smallest[i][0] == c[i]:
                for better_index in range(i, len(s)):
                    if s[better_index] > right_smallest[i][0]:
                        continue
                    s[i], s[better_index] = s[better_index], s[i]
                    if "".join(s)[i:] < c[i:]:
                        return "".join(s)
                    s[i], s[better_index] = s[better_index], s[i]
                return "---"
            else:
                return "---"
    return "---"


T = int(input())

for _ in range(T):
    s, c = input().split()
    ans = get_smallest(s, c)
    print(ans)
