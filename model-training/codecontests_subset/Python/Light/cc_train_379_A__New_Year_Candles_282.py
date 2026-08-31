a , b = input().split()
a = int(a)
b = int(b)

rez = a
while a>0:
    rez += int(a/b)
    a = int(a/b) + a%b
    if int(a/b)==0:
        break

print(rez)
