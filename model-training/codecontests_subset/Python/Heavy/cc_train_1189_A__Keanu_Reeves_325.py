n = int(input())
s = list(input())
for i in range(n):
    s[i] = int(s[i])
if sum(s) != len(s) // 2 or len(s) % 2 == 1:
    print(1)
    for i in s:
        print(i, end="")
else:
    s1 = s[:len(s) // 2]
    s2 = s[len(s) // 2:]
    print(2)
    if len(s1) % 2 == 0:
        for i in range(n // 2 - 1):
            print(s1[i], end="")
        print(" ", s1[-1], end="")
        for i in s2:
            print(i, end="")
    else:
        for i in s1:
            print(i, end="")
        print(end=" ")
        for i in s2:
            print(i, end="")


