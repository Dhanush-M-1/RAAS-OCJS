
n = int(input())

a = [int(a) for a in input().split()]
a.sort()



b = [int(b) for b in input().split()]
b.sort()
b.append(0)

c = [int(c) for c in input().split()]
c.sort()
c.append(0)

for i in range(len(b)):
    #print(b[i])
    if b[i] != a[i]: 
        print(str(a[i]))
        break
    
for j in range(len(c)):
    #print(c[j])
    if c[j] != b[j]:
        print(str(b[j]))
        break
    
    

