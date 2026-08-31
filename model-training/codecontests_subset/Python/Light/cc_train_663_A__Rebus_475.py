s = ('+ ' + input()).strip().split()
plus = 0
minus = 0
for c in s:
    if c == '+':
        plus += 1
    elif c == '-':
        minus += 1

n = int(s[-1])

maxn = plus * n - minus
minn = plus - minus * n

if not (maxn >= n >= minn):
    print("Impossible")
    exit()

ans = []

for i in range(1, len(s)):
    need = min(maxn - n, n - 1)
    
    if s[i-1] == '+':
        ans.append(str(n - need))
        maxn -= need
    elif s[i-1] == '-':
        ans.append(str(1 + need))
        maxn -= need
    else:
        ans.append(s[i])
print("Possible")
print(' '.join(ans))