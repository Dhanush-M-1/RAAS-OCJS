a=input()
l=list(a)
one=0
two=0
three=0
s=[]
for i in range(0,len(l),2):
    if(l[i]=='1'):
        one+=1
    elif(l[i]=='2'):
        two+=1
    elif(l[i]=='3'):
        three+=1
for p in range(one):
    s.append('1')
    if(two!=0 or three!=0):
        s.append('+')
    else:
        if(p<one-1):
            s.append('+')
for q in range(two):
    s.append('2')
    if ( three != 0):
        s.append('+')
    else:
        if (q < two - 1):
            s.append('+')
for r in range(three):
    s.append('3')
    if(r<three-1):
        s.append('+')
sum=''.join(s)
print(sum)