from pprint import pprint as pp
def GI(): return int(input())
def GIS(): return map(int, input().split())

from collections import deque

def main():
  n = GI()
  ps = deque(GIS())
  seconds = 0
  l = 1
  r = 10 ** 6

  while ps:
    seconds += 1
    l += 1
    r -= 1

    if ps[0] == l:
      ps.popleft()
    if ps and ps[-1] == r:
      ps.pop()


  print(seconds)

main()
