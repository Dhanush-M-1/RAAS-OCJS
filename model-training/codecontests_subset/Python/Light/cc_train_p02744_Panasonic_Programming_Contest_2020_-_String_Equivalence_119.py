def saiki(s, n, m):
  if n == 0:
    print(s)
    return
  
  a = ord('a')
  c = ord(m) + 2
  
  
  for i in range(a, c):
    saiki(s+chr(i), n-1, chr(max(i, ord(m))))
    
n = int(input())

saiki('a',n-1, 'a')