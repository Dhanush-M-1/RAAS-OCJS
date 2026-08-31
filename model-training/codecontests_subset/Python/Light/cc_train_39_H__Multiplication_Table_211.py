radix = int(input())
for i in range(1, radix):
  row = []
  for j in range(1, radix):
    x = i * j
    digits = []
    while x != 0:
      digits.append(str(x % radix))
      x //= radix
    row.append(''.join(reversed(digits)))
  print(' '.join(row))
