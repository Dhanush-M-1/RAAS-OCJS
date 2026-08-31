names = list(map(str, input().split()))
n = int(input())
print(*names)
for i in range(n):
    s1, s2 = map(str, input().split())
    if names[0] == s1:
        names[0] = s2
    else:
        names[1] = s2
    print(*names)
