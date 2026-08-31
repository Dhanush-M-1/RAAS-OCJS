a, b = map(int,input().split())
count = 0
c = 0
while a>=1:
    count += 1
    c = c + 1
    a = a-1
    if c == b:
        c=0
        a+=1
print(count)