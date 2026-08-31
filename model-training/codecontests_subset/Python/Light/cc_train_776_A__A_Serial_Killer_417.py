s = input().split()
n = int(input())
killed = [0]*n
for i in range(n):
    killed[i] = input().split()
print(s[0], s[1])
for i in range(n):
    if killed[i][0] == s[0]:
        s[0] = killed[i][1]
    else:
        s[1] = killed[i][1]
    print(s[0],s[1])