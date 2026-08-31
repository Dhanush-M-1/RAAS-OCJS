import sys
input = sys.stdin.readline
 
def main():
  t = int(input())
  for _ in range(t):
      n = int(input())
      seq = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
      prevTry = 0
      prevClear = 0
      res = "YES"
  
      for s in seq:
          if s[0] < s[1]:
              res = "NO"
              break
          if s[0] < prevTry or s[1] < prevClear:
              res = "NO"
              break
          if s[0] == prevTry and s[1] > prevClear:
              res = "NO"
              break
          if s[0]-prevTry < s[1]-prevClear:
              res = "NO"
              break
          prevTry = s[0]
          prevClear = s[1]
  
      print(res)

main()