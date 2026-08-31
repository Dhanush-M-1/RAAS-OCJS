i = input()
li = list(i.split(" "))
a = int(li[0])
b = int(li[1])

c = int(0)
d = int(0)
e = int(0)
e = a
while(True):
    if(e==0):
        break
    else:
        c = c + e
        e = (a//b)
        d = (a % b)
        a = e + d
print(c)
