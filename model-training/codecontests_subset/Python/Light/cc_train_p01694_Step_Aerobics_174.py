import math
while True:
  answer = 0
  count = int(input())
  if count == 0: break
  orders = input().split(' ')

  for i in range(int(math.floor(count / 2))):
    s = orders[ 2 * i: 2*i+2 ]
    if not(s[0][0] == s[1][0]) and (s[0][1] == s[1][1]):
      answer += 1
  
  print(answer)

