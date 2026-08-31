n = int(input())

l = []
for _ in range(3):
    l.append(list(map(int, input().split())))
    
d1 = {}
d2 = {}
for i in l[0]:
    if i not in d1:
        d1[i] = 1
    else:
        d1[i] += 1
        
for i in l[1]:
    if i not in d2:
        d2[i] = 1
    else:
        d2[i] += 1
    d1[i] -= 1
        
for i in l[2]:
    d2[i] -= 1
    
for i in d1:
    if(d1[i] == 1):
        print(i)
for i in d2:
    if(d2[i] == 1):
        print(i)
