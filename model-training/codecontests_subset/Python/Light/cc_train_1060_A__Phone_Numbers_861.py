def ii():
    return int(input())
def mi():
    return map(int, input().split())
def li():
    return list(mi())

n = ii()
s = input().strip()
eight = s.count('8')
rem = len(s) - eight
cnt, extra = divmod(rem, 10)
if eight <= cnt:
    ans = eight
else:
    ans = cnt
    eight -= cnt
    if eight + extra >= 11:
        ans += 1
        eight -= 11 - extra
        ans += eight // 11
print(ans)