n = int(input())

s = input()

counter = 0

for c in s:
  if c == '8':
    counter += 1

if counter == 0 or n < 11:
  print('0')
elif counter > n / 11 :
  print(int(n / 11))
else :
  print(counter)