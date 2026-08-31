import math,itertools,fractions,heapq,collections,bisect,sys,queue,copy

sys.setrecursionlimit(10**7)
inf=10**20
mod=10**9+7
dd=[(-1,0),(0,1),(1,0),(0,-1)]
ddn=[(-1,0),(-1,1),(0,1),(1,1),(1,0),(1,-1),(0,-1),(-1,-1)]

def LI(): return [int(x) for x in sys.stdin.readline().split()]
# def LF(): return [float(x) for x in sys.stdin.readline().split()]
def I(): return int(sys.stdin.readline())
def F(): return float(sys.stdin.readline())
def LS(): return sys.stdin.readline().split()
def S(): return input()

def main():
  n=I()
  ans=[]

  for _ in range(n):
    a=I()
    b=c=0
    while True:
      if a%2!=0:
        break
      b+=1
      a//=2

    while True:
      if a%3!=0:
        break
      c+=1
      a//=3

    if a!=1:
      ans.append(-1)
    else:
      if b>c:
        ans.append(-1)
      else:
        ans.append(c*2-b)

  for x in ans:
    print(x)

main()
# print(main())
