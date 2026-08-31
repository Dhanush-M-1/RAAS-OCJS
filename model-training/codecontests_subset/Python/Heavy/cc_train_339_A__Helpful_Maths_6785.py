def quicksort(b):
    large=[]
    small=[]
    equal=[]
    if len(b)<2:
        return b
    else:
        basement=b[0]
        j=0
    while j<len(b):
        if b[j]>basement:
            large.append(b[j])
        elif b[j]<basement:
            small.append(b[j])
        else:
            equal.append(b[j])
        j=j+1
    return quicksort(small)+equal+quicksort(large)
a=input()
i=0
b=[]
c=[]
d=[]
while i<len(a):
    b.append(int(a[i]))
    i=i+2
c=quicksort(b)
for i in range(len(c)-1):
    d.append(c[i])
    d.append('+')
d.append(c[len(c)-1])
print(''.join('%s' %id for id in d))

    
