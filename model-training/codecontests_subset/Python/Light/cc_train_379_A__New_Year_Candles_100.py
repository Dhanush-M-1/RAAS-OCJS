a,b = [int(i) for i in input().split()]
c = 1
while c <= a:
    if c%b == 0:a+=1
    c+=1
print(a)