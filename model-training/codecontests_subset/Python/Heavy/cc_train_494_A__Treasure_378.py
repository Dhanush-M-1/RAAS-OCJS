s = input()
l = []
b = False
u = [0] * len(s)
for i in range(len(s) - 2, -1, -1):
    u[i]  = u[i + 1] + (s[i + 1] != '(')
    u[i] -= (s[i + 1] == '(')
    u[i]  = max(u[i], 0)

d = 0
for i in range(len(s)):
    if s[i] == '#':
        l += [d - u[i]]
        d -= d - u[i]
        b  = True
    elif s[i] == ')':
        d -= 1
        if d < 0 and not b:
            l += [-1]
            break
    else:
        d += 1
d = 0
b = False
for i in range(len(s)-1,-1,-1):
    if s[i] == '#':
        b  = True
        break
    elif s[i] == '(':
        d -= 1
        if d < 0 and not b:
            l += [-1]
            break
    else:
        d += 1

if min(l) < 1:
    print(-1)
else:
    for i in l:
        print(i)