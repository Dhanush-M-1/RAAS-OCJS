c=int(input())
s=input()
p=[i for i in s]
a=p.count("A")
i=p.count("I")
f=p.count("F")
if i==0:
    print(a)
elif i==1:
    print(i)
else:
    print(0)