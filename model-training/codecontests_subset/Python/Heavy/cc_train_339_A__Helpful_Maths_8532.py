str = input()
one = 0
two = 0
three= 0
res = ""
for N in str:
    if N != '+':
        if N == '1':
            one+=1
        if N == '2':
            two+=1
        if N == '3':
            three+=1
            
for i in range (0, one):
    res += "1"
    if i==one-1:
        if two!=0 or three!=0:
            res += "+"
    else:
        res += "+"
        
for i in range (0, two):
    res += "2"
    if i==two-1:
        if three!=0:
            res += "+"
    else:
        res += "+"
        
for i in range (0, three):
    res += "3"
    if i!=three-1:
        res += "+"
        
print (res)