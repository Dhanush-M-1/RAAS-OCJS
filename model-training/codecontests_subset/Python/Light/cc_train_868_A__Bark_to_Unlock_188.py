def solve(arr,s,n):
  res = []
  for i in arr:
    for j in arr:
      res.append(i+j)
      res.append(j+i)
  for i in res:
    if s in i:
      return 'YES'
  return 'NO'
  
 




    

  
def main() :
  s = input()
  n = int(input())
  # arr = list(map(int, input().split(' ')))
  arr = []
  # res=''
  for _ in range(n):
    i = input()
    arr.append(i)
  print(solve(arr,s,n))
main()
