pw = input()
n = int(input())
a = [input() for _ in range(n)]
if (pw in a) or ((pw[0] in [s[1] for s in a]) and (pw[1] in [s[0] for s in a])):
    print('YES')
else:
    print('NO')