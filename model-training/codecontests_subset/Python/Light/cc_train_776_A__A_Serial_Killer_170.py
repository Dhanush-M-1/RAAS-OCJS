s = input()
day = int(input())
victim = [s]
while day > 0 :
    k = input().split()
    v = victim[-1].split()
    for x in range(len(v)):
        if v[x] == k[0]:
            v[x] = k[1]
              
    victim.append(" ".join(v))
    day -= 1

for y in victim:
    print (y)
    
    
    
