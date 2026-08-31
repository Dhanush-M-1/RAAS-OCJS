s = list(input().split())
print(*s)
cases = int(input())
while cases:
    cases -= 1
    names = list(input().split())
    ind = s.index(names[0])
    s[ind] = names[1]
    print(*s)
