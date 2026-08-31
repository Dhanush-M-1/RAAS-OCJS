s, t = input().split()
print(s, t)
for i in range(int(input())):
    u, v = input().split()
    if s == u:
        s = v
    else:
        t = v
    print(s, t)