def solve(s,n):
  d = {}
  for i in s:
    if not d.get(i):
      d[i] = 1
    else:
      d[i] += 1
  res = ''
  for i in d:
    if d[i] % n != 0:
      return -1
    
      
  for i in d:
    res+=i*(d[i]//n)
  return res*n
    

def main() :
  # n,k = list(map(int, input().split(' ')))
  # n = int(input())
  # arr = input().split(' ')
  # s = input()
  # res=''
  # arr = []
  # for _ in range(n):
  #   i = input()
  #   arr.append(i)
  
  # for i in arr:
  n = int(input())
  s = input()
  print(solve(s,n))

main()


