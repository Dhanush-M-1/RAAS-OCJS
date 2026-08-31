n = int(input())
a = input()
b = input()
c = input()
a = [int(x) for x in a.split()]
b = [int(x) for x in b.split()]
c = [int(x) for x in c.split()]
sa=0
sb=0
sc=0
for i in a:
    sa=sa+i


for i in b:
    sb=sb+i

for i in c:
    sc=sc+i

print(sa - sb)
print(sb - sc)
