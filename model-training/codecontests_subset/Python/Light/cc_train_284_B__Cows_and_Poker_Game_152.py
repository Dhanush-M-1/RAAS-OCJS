n=int(input())
s=input()
f=s.count("F")
A=s.count("A")
I=s.count("I")
if I==0 :
  print(A)
elif I==1 :
  print(1)
else :
  print(0)