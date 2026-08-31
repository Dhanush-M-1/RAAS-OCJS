from collections import  Counter
def get_ans():
    n = input()
    c = Counter(input())
    a = c['A']
    f = c['F']
    i = c['I']
    if i != 0:
        if i != 1:
            return 0
        else:
            return 1

    if c['A'] != 0:
        return c['A']

    return 0

ans = get_ans()
print(ans)