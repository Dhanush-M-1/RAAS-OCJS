str = 'abcdefghijklmnop'
def bt(n,m,s):
  if n == 0:
    print(s)
    return
  for c in range(m):
    bt(n-1,m,s+str[c])
  #introduce another character
  bt(n-1,m+1,s+str[m])
n = int(input())
bt(n,0,'')