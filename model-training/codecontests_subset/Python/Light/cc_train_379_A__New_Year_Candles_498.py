a, b = map(int, input().split())
c = 0
count = 0
while a > 0:
    count+=1
    a -= 1
    c += 1
    if c//b == 1:
        a+=1
        c=0
print(count)
