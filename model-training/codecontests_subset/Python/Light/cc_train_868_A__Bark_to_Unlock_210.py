import sys

def ReadInput():
    return sys.stdin.read().splitlines()

def main():
  input = ReadInput()
  pwd = input[0]
  words = input[2:]
  if pwd in words:
    print('YES')
    return

  if any(pwd[0] == x[1] for x in words) and any(pwd[1] == x[0] for x in words):
    print('YES')
    return

  print('NO')

main()