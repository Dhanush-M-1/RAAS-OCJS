alp='abcdefghijklmnopqrstuvwxyz'

def f(N, s, x):
  if len(s)==N:
    print(s)
    return
  for i in range(x+2):
    f(N, s+alp[i], max(x, i))
    
f(int(input()), 'a', 0)