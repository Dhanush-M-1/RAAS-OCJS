t = list(input().split())
print(*t)
for _ in range(int(input())):
    s = list(input().split())
    t.remove(s[0])
    t.append(s[1])
    print(*t)
