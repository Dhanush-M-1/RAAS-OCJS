n=int(input())
l=input()
l=list(l)
a=l.count("8")
if a<=len(l)//11:
  print(a)
elif a>=len(l)//11:
  print(len(l)//11)
else:
  print("0")