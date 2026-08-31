pas = input()
n = int(input())
l = [input() for _ in range(n)]
s = set()
for i in l:
    for j in l:
        s.add(i + j)
        s.add(j + i)
found = False
for a in s:
    if pas in a:
        found = True

print('Yes' if found else 'No')
