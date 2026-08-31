a,b=map(int,input().split())
sum1=a
while a>=b:
  re=int(a/b)
  a=re+a%b
  sum1=sum1+re
print(sum1)