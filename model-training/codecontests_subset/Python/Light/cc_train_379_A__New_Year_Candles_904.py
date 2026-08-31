s = input().split()
a = int(s[0])
b = int(s[1])
c = 0
while a > 0:
    c+=1
    a-=1
    if c % b == 0:
        a+=1
print(c)

