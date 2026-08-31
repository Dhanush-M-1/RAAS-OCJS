n = int(input())
s = input()
a=s.count("I")
if a==1:
    print(1)
elif a>1:
    print(0)
else:
  b=s.count("A")
  print(b)