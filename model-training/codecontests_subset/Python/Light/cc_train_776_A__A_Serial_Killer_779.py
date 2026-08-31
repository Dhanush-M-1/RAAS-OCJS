# import numpy
def Main():
  X, Y = map(str, input().split())
  print(X, Y)
  n = int(input())
  for _ in range(n):
    A, B = input().split()
    if X == A:
      X = B
    elif Y == A:
      Y = B
    print(X, Y)
      
if __name__ == '__main__':
  Main()