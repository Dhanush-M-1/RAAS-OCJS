r1, r2 = map(int, input().split())
c1, c2 = map(int, input().split())
d1, d2 = map(int, input().split())
def valid(s):
    if not 1 <= min(s) <= 9:
        return False
    elif not 1 <= max(s) <= 9:
        return False
    elif len(s) != len(set(s)):
        return False
    elif s[2] + s[3] != r2:
        return False
    elif s[1] + s[3] != c2:
        return False
    elif s[1] + s[2] != d2:
        return False
    else:
        return True
for i in range(1, min(r1, c1, d1)):
    if valid([i, r1 - i, c1 - i, d1 - i]):
        print(i, r1 - i)
        print(c1 - i, d1 - i)
        exit()
print(-1)
