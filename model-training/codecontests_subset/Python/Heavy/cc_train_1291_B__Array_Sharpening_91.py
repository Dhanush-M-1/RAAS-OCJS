from sys import stdin, stdout

class Solve:
  def __init__(self):
    R = stdin.readline
    W = stdout.write
    ans = []
    for _ in range(int(input())):
      n = int(input())
      a = [int(x) for x in R().split()]
      r = -1
      for i in range(n):
        if a[i] < i:
          break
        r += 1
      l,tmp = n,0
      for i in range(n-1, -1, -1):
        if a[i] < tmp:
          break
        tmp += 1
        l -= 1
      if l <= r:
        ans.append('Yes')
      else:
        ans.append('No')
    W('\n'.join(ans))
      
def main():
  s = Solve()

main()