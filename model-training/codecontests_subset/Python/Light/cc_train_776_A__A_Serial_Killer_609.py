from sys import stdin, stdout

names = set(stdin.readline().split())
n = int(stdin.readline())
ans = [list(names)]


for i in range(n):
    first, second = stdin.readline().split()
    names.discard(first)
    names.add(second)
    ans.append(list(names))

for i in range(n + 1):
    stdout.write(' '.join(ans[i]) + '\n')