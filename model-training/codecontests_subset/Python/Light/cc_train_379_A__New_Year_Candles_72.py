line = input()
a = int(line.split()[0])
b = int(line.split()[1])
res = 0
while (a>0):
    if (b<=a):
        a-=b-1
        res+=b
    else:
        res+=a
        a = 0
print(res)
