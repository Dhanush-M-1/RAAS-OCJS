for x in range(int(input())):
  l,r,d=map(int,input().split())
  if d < l:
    print(d)
    continue
  print(d*(int(r/d)+1))