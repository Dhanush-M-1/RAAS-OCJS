#In the name of Allah

from sys import stdin, stdout
input = stdin.readline


n, m = map(int, input().split())

b = [list(map(int, input().split()))for i in range(n)]
l = [False] * (m + 1)
l[0] = True
for i in b:
        for j in i[1:]:

                l[j] = True
if False in l:
        stdout.write("NO")
else:
        stdout.write("YES")
