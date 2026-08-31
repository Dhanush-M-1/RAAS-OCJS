a = input()
b = int(input())
c=[]
for j in range (b):
    c.append(input())
p = "NO"
for i in c:
    if i[::-1]==a or i==a:
        p = "YES"
    if (i[1]==a[0]):
        c.remove(i)
        for i in c:
            if i[0]==a[1]:
                p = "YES"
print (p)