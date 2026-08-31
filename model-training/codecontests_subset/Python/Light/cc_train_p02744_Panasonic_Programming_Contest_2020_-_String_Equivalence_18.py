N = int(input())

def standard(n, cur):
  if n == 0:
    print(''.join(cur))
  else:
    newC = chr(ord(sorted(cur)[-1]) + 1)
    for c in sorted(set(cur + [newC])):
      standard(n - 1, cur + [c])

standard(N - 1, ['a'])