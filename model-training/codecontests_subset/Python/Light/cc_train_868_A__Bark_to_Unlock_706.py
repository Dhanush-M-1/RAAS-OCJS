s = input()
n = int(input())
a = [input() for i in range(n)]
flag = int(s in a)
for i in range(n):
    for j in range(n):
        if a[i][-1] == s[0] and a[j][0] == s[1]:
            flag = 1
print('YES' if flag else 'NO')