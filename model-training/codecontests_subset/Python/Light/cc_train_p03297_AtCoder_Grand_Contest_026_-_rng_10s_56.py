import fractions as f
for i in range(int(input())):
 a,b,c,d=map(int,input().split())
 g=f.gcd(b,d)
 print("No" if a<b or b>d or a-((a-b)//g+1)*g>c else "Yes")