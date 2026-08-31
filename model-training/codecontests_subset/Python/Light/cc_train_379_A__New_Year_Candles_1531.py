n,a=map(int,input().split())
t=0
while n>=a:
      n=n-a+1
      t+=a

t+=n
print(t)
