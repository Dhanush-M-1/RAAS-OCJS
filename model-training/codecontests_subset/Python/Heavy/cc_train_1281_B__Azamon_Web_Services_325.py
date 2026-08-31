def best(s):
    new = ""
    for idi, l in enumerate(s):
        if idi and s[idi] == s[idi - 1]:
            continue
        besti = [l, 0]
        for idj, m in reversed(list(enumerate(s))):
            if idi == idj:
                break
            if m < besti[0]:
                besti = [m, idj]
        if besti != [l, 0]:
            new = s[0:idi] + s[besti[1]] + \
                s[idi + 1:besti[1]] + s[idi] + s[besti[1] + 1:]
            break
    return new if new != "" else s


n = int(input())
for _ in range(n):
    s, t = input().split()
    s = best(s)
    if s < t:
        print(s)
    else:
        print("---")
