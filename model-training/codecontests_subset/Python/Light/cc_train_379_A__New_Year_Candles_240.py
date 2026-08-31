a,b = input().split(' ')
a = int(a)
b = int(b)
count = 0
r = 0
while a>0 :
    count += a
    r += a
    a = int(r/b)
    r = r%b
print(count)
