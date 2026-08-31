n = [int(x) for x in input().split(' ')]

count = n[0]
remain = 0
t = 0
while t == 0:
    remain = n[0]%n[1]
    n[0] = n[0]//n[1]
    
    if n[0] >= 1:
        count += n[0]
        n[0] += remain
    else:
        break

print(int(count))
