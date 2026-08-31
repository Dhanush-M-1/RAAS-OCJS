import math
def solve(n,x,y):
  p = math.ceil(n*y/100)
  if x >= p:
    return 0
  return abs(p-x)
    
  
def main():
  i =list(map(int,input().split(' ')))
  print(solve(*i))

main()