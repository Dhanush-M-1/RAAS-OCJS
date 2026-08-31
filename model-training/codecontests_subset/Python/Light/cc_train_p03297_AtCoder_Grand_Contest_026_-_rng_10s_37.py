import fractions as f
for i in range(int(input())):
 a,b,c,d=list(map(int,input().split()))
 g=f.gcd(b,d)
 if a<b or b>d or a-((a-b)//g+1)*g>c:
  print("No")
 else:
  print("Yes")