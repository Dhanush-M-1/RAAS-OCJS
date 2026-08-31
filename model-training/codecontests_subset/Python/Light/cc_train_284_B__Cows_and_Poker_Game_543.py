n=int(input())
s=input()
a,f,i=s.count('A'),s.count('F'),s.count('I')
if a+f==n:
    print(a)
elif a==n:
    print(a)
elif f==n or i==n:
    print(0)
elif i==1:
    print(i)
elif i>1:
    print(0)
