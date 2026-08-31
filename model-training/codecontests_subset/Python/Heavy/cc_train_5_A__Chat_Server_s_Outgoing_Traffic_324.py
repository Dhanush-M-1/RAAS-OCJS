"""
Codeforces
5A - Chat Server's Outgoing Traffic
http://codeforces.com/contest/5/problem/A

Héctor González Belver
../07/2018
"""
import sys

def main():
  participants = 0
  total_length = 0

  while True:
    line = sys.stdin.readline().strip()
    if not line:
      break
    first_char = line[0]
    if first_char == '+':
      participants += 1
    elif first_char == '-':
      participants -= 1
    else:
      total_length += len(line[line.index(':')+1:]) * participants

  sys.stdout.write(str(total_length) + '\n')
 
if __name__ == '__main__': 
  main()