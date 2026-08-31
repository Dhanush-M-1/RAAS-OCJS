t=int(input())
while(t):
  n=int(input())
  a=list(map(int,input().split()))
  b,c,e=a[0],a[1],a[-1]
  if(b+c<=e):
    print("1 2 %d"%(n))
  else:
    print("-1")
  t-=1