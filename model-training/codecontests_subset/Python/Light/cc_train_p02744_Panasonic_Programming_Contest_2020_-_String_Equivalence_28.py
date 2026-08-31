import string

S = string.ascii_lowercase
N = int(input())


def a(s="", distinct=0):
  if len(s) == N:
    print(s)
    return

  for i in range(distinct + 1):
    c = S[i]
    a(s + c, distinct + (1 if c not in s else 0))


a()
