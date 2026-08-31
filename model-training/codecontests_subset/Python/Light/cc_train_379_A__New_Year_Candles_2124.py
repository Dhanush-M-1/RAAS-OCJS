a,b=map(int,input().split())
ans = a
bank = 0
while a//b!=0:
  bank = a%b
  a-=bank
  ans+=a//b
  a=a//b
  a+=bank
print(ans)