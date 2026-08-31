a,b=map(int, input().split())
sum=a
while a>=b:
  n=int(a/b)
  sum+=n
  a=n+a%b


print (int(sum))