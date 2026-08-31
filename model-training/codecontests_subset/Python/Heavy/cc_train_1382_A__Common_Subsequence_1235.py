# input = open('file.txt').readline

for _ in range( int(input()) ):

  n , m = map( int , input().strip().split(" ") )
  arr = list(map( int , input().strip().split(" ") ))
  brr = list( map( int , input().strip().split(" ") ) )

  arr.sort()
  brr.sort()

  num = [ 0 for i in range(1001) ]

  for a in arr:
    if num[a] == 0:
      num[a] = 1
  for b in brr:
    if num[b] == 1:
      num[b] = 2
  
  ans = -1
  for i,a in  enumerate(num):

    if a > 1:
      ans = i
      break
  
  if ans == -1:
    print('NO')
  else:
    print('YES')
    print(1,ans)