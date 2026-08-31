s1, s2 = input().split()
n = int(input())
print(s1, s2)
for i in range(n):
    rep, new = input().split()
    if s1 == rep:
        s1 = new
    else:
        s2 = new
    print(s1, s2)
