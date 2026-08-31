def solve():
    s, c = input().split()
    mins = [char for char in s]
    for i in range(len(s) - 2, -1, -1):
        mins[i] = min(mins[i], mins[i + 1])
    a, b, j = '', '', -1
    for i in range(len(s)):
        if s[i] != mins[i]:
            a = s[i]
            b = mins[i]
            j = i
            break
    if j != -1:
        k = max((i for i in range(len(s)) if s[i] == b))
        string = list(s)
        string[j], string[k] = string[k], string[j]
        s = ''.join(string)
    if s < c:
        print(s)
    else:
        print('---')


for _ in range(int(input())):
    solve()
