a, b = input().split()
print( a, b )
n = int( input() )
for i in range( n ):
  s, t = input().split()
  if a == s:
    a = t
  else:
    b = t
  print( a, b )
