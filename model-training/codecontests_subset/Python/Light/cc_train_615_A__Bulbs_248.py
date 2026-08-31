def solve(arr,n,m):
  s = set()
  for i in arr:
    k = i[0]
    j = 1
    while k:
      s.add(i[j])
      j+=1
      k-=1
  return "YES" if len(s) == m else "NO"



def main():
  n,m = list(map(int, input().split(' ')))
  arr = []
  for i in range(n):
    arr.append(list(map(int, input().split(' '))))
  print(solve(arr,n,m))

main()
