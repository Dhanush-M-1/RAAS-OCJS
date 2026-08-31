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
    a,b=LI()
    l1=LI()
    d={}
    for x in l1:
      d[x]=x
    l2=LI()

    f=False
    for x in l2:
      if x in d:
        f=True
        ans.append(x)
        break
    if not f:
      ans.append(-inf)

  for x in ans:
    if x==-inf:
      print('NO')
    else:
      print('YES')
      print(1,x)

main()
# print(main())
