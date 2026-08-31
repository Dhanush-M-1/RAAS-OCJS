a,k=map(str,input().split())
n=int(input())
l=''
print(a+' '+k)
for i in range(n):
  b,c=map(str,input().split())
  if a==b:
    l=a.replace(b,c)+' '+k
    a=c
  else:
    l=a+' '+k.replace(b,c)
    k=c
  print(l)