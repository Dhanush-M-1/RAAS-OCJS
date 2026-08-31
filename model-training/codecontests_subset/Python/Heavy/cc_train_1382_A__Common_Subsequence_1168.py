import sys
sys.setrecursionlimit(2147483647)
input=sys.stdin.readline

def solve(a,b):
  for aa in a:
    if aa in b:
      return aa
  else:
    return None

def main():
  t = int(input())
  arr = []
  for _ in range(t):
    input()
    a = list(map(int, input().split(' ')))
    b = list(map(int, input().split(' ')))
    arr.append([a,b])
  for i in range(t):
    a, b = arr[i]
    ans = solve(a,b)
    if(ans):
      print('YES')
      print(f'1 {ans}')
    else:
      print('NO')

if __name__=='__main__':
  main()