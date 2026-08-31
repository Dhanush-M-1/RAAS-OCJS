def solve(arr,s,n):
  for i in arr:
    for j in arr:
      if s in i+j or s in j+i:
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
