password = input()
n = int(input())
words = []
myset = set()
for _ in range(n):
  s = input()
  words.append(s)
  myset.update([s, s[::-1]])
for i in range(n):
  for j in range(i + 1, n):
    myset.update([words[i][1] + words[j][0], words[j][1] + words[i][0]])
if password in myset:
  print('YES')
else:
  print('NO')