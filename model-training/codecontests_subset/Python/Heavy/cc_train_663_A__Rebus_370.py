import math

def solve():
  eq = input()
  num_plus = eq.count('+') + 1
  num_minus = eq.count('-')
  qmark = eq.count('?')
  qmark -= num_minus
  divid = [i for i in eq.split()]
  n = int(divid[-1])
  t = n + num_minus - num_plus

  if t != 0 and n == 1:
    print('Impossible')
    return

  fill_to_n = math.ceil(abs(t) / (n - 1)) if n > 1 else 0
  if (t > 0 and fill_to_n > num_plus) or (t < 0 and fill_to_n > num_minus):
    print('Impossible')
    return

  if t > 0:
    if fill_to_n > 0:
      divid[0] = t % (n - 1) + 1 if t % (n - 1) != 0 else n
      fill_to_n -= 1
    else:
      divid[0] = 1
  else:
    divid[0] = 1

  for i in range(1, len(divid)):
    if divid[i] == '?':
      divid[i] = 1
    if t > 0:
      if divid[i - 1] == '+':
        if fill_to_n > 0:
          divid[i] = n
          fill_to_n -= 1
    elif t < 0:
      if divid[i - 1] == '-':
        if fill_to_n > 0:
          divid[i] = n
          fill_to_n -= 1

  if t < 0 and abs(t) % (n - 1) != 0:
    for i in range(len(divid)):
      if divid[i - 1] == '-':
        divid[i] = abs(t) % (n - 1) + 1
        break;

  print('Possible')
  print(*divid, sep = ' ')

if __name__ == '__main__':
  solve()
