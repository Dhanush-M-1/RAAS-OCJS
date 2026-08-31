import math
n, p = list(map(int, input().split()))
li = []
box = []
m = 1
k = 1
q = p
 
while True:
    for i in range(2,int(math.sqrt(q)) + 1):
        if p % i == 0:
            p = p // i
            li.append(i)
            k = i
            break
        else:
            continue
    else:
        break
 
for i in range(2,k+1):
    if i in li:
        box.append(i)
 
if n > len(li):
    print(m)
elif n==1:
  print(q)
else:
    for j in box:
        if li.count(j) // n > 0:
            m *= j ** (li.count(j) // n)
    print(m)
