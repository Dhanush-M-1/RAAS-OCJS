n=int(input())
a=input()
A=a.count('A')
F=a.count('F')
I=a.count('I')
if A>=0 and F>=0 and I==0:
    print(A)
elif F>=0 and I==1:
    print(1)
else:
    print(0)