n = int(input())
s=input()
a = s.count('A')
f = s.count('F')
i = s.count('I')
if(i>0 and i==1):
    print(1)
elif(i==0 and a>0):
    print(a)
else:
    print(0)