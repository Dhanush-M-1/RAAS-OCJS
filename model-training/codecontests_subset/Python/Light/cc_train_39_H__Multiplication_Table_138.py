def convert_base(number, base):
    if base < 2:
        return False
    remainders = []
    while number > 0:
        remainders.append(str(number % base))
        number //= base
    remainders.reverse()
    return ''.join(remainders)
n = int(input())
for i in range(1,n):
  s = ''
  for j in range(1,n):
    s += str(convert_base(i * j, n)) + ' '
  s = s[:-1]
  print(s)
