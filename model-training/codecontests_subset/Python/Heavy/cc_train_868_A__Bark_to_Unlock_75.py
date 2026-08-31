from sys import stdin, stdout

pwd = input()
n = stdin.readline()
n = int(n)
check1, check2 = 0, 0
for _ in range(n):
  p = input()
  if p[::-1] == pwd or p == pwd:
    stdout.write("YES\n")
    check1, check2 = 1, 1
    break
  else:
    if pwd[0] in p and (p.index(pwd[0]) == 1 or set(p) == set(pwd[0])) and check1 == 0:
      check1+=1
    if pwd[1] in p and (p.index(pwd[1]) == 0 or set(p) == set(pwd[1])) and check2 == 0:
      check2+=1
    if check1 + check2 == 2:
      stdout.write("YES\n")
      break
if check1 + check2 < 2:
  stdout.write("NO\n")