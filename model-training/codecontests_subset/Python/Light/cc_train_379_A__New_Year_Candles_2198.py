a,b = map(int,input().split())
total = a
left = 0
for i in range(a):
    t = a//b
    left = a%b
    a = left+t
    if t == 0:
        break
    else:
        total += t
print(total)