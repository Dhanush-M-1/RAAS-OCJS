
n = int(input())

for i in range(n):
  order = input()[::-1]
  message = input()

  for s in order:
    if s == 'J':
      message = message[len(message) - 1] + message[:len(message) - 1]
    elif s == 'C':
      message = message[1:] + message[0]
    elif s == 'E':
      message = message[(len(message)+1)//2:] + message[len(message)//2:(len(message) + 1)//2] + message[:len(message)//2]
    elif s == 'A':
      message = message[::-1] 
    elif s == 'P':
      temp = ''
      for c in message:
        if c == '0':
          c = '9'
        elif c > '0' and c <= '9':
          c = chr(ord(c) - 1)
        temp += c
      message = temp
    elif s == 'M':
      temp = ''
      for c in message:
        if c == '9':
          c = '0'
        elif c >= '0' and c < '9':
          c = chr(ord(c) + 1)
        temp += c
      message = temp
  print(message)      