s=input()
n=[int(i) for i in s.split()]
a=n[0]
b=n[1]
tnoc=a
tnoc+=int(a/b)
a=int(a/b)+int(a%b)
while a>=b:
        tnoc+=int(a/b)
        a=int(a/b)+int(a%b)
print(tnoc)
