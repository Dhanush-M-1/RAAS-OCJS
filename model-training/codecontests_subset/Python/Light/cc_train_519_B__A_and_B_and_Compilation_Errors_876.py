input()
I=lambda:sorted(map(int,input().split()))
a=I()
b=I()
def f(a,b):
 for i in range(len(b)):
  if a[i]!=b[i]:return a[i]
 return a[-1]
print(f(a,b),"\n"+str(f(b,I())))