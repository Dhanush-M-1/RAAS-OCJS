q=int(input())
while q>0:
  q=q-1;
  n=int(input())
  lst=[None]*n
  lst=list(map(int,input().split()))
  if lst[0]+lst[1]<=lst[-1]:
    print(1,2,n)
  else:
    print(-1)