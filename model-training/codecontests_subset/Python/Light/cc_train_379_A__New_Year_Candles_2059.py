s = str(input()).split()
a = int(s[0])
b = int(s[1])
c = 1
t = a

while a / b >= 1:
    t += a // b
    a = a // b + a % b

print(t)