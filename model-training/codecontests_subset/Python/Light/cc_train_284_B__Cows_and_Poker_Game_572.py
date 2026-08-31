n =  int(input())

adict = {}
adict['A'] = 0
adict['F'] = 0
adict['I'] = 0

s = input()
for a in s:
    if a=='A':
        adict['A'] += 1
    elif a=='F':
        adict['F'] += 1
    elif a=='I':
        adict['I'] += 1
        
        
count = 0
if adict['I']==0:
    count += adict['A']

if adict['I']==1:
    count += adict['I']
print(count)        
    
    