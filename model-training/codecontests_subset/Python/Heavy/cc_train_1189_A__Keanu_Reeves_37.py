import collections
import math
import sys
import itertools
import itertools

def sa(Type= int):
  return [Type(x) for x in input().split()]

def isGood(s):
  oneCc = 0
  zeroCc = 0

  for x in s:
    if x == '1':
      oneCc += 1
    else:
      zeroCc += 1

  return oneCc != zeroCc

def solve(t):
  n = int(input())
  s = input()

  if isGood(s):
    print(1)
    print(s)
    return

  print(2)
  print(s[0], s[1::])


if __name__ == '__main__':
  # sys.stdin = open('input.txt', 'r')

  # t = int(input())
  # for i in range(t):
  #   solve(i+1)

  solve(0)
