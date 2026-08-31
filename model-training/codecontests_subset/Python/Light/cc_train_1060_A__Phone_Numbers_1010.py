n = int(input())

num = int(input())
p = 0
count = 0
c = 0
a=[0]
while n != 0:

    if (num % 10) == 8:
        p += 1
        c-=1
    num //= 10
    c += 1
    n-=1
#print(c,p)

while c >= 10 and p > 0:
    c -= 10
    p -= 1
    count += 1
#print(c,p)
if p>0:
    count=count+(c+p)//11
print(count)
