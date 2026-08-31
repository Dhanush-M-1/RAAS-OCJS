def main(a,b,c,d):
  if a<b:return 'No'
  if d<b:return 'No'
  if b<=c+1:return 'Yes'
  if d%b==0:
    if a%b<=c:return 'Yes'
    return 'No'
  # 任意のiで(a+i*d)%b<=cを満たせばOK
  import math
  g=math.gcd(d%b,b)
  e0=a%d
  if g*((b-1-e0)//g)+e0<=c:return 'Yes'
  return 'No'


t=int(input())
abcd=[list(map(int,input().split())) for _ in range(t)]
for a,b,c,d in abcd:
  print(main(a,b,c,d))