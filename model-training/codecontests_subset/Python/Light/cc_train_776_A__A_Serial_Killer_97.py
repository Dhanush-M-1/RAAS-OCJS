s = list(map(str, input().split()))
print(*s)
for cas in range(int(input())):
    t = list(map(str, input().split()))
    if s[0] == t[0]:
        s[0] = t[1]
    elif s[0] == t[1]:
        s[0] = t[0]
    elif s[1] == t[0]:
        s[1] = t[1]
    else:
        s[1] = t[0]
    print(*s)