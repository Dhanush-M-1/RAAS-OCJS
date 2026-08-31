#00:33
t = int(input())
for _ in range(t):
  a,b,c,d = map(int,input().split())
  if d - b < 0:
    print('No')
    continue
  if a - b < 0:
    print('No')
    continue
  big = int(b)
  sml = int(d)
  while sml != 0:
    big,sml = sml,big%sml
  gcd = big
  r = (a-c-1) % gcd + 1
  if r + c >= b:
    print('Yes')
  else:
    print('No')