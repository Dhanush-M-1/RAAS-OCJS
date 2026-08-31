s=str(input())
l=[]
for i in s:

    if i.isdigit():
        l.append(int(i))

def mergesort(ls):
    if len(ls)>1:
        mid=len(ls)//2
        l=ls[:mid]
        r=ls[mid:]
        mergesort(l)
        mergesort(r)
        i=j=m=0
        while i<len(l) and j<len(r):
            if l[i]<r[j]:
                ls[m]=l[i]
                i+=1
            else:
                ls[m]=r[j]
                j+=1
            m+=1
        while i<len(l):
            ls[m]=l[i]
            i+=1
            m+=1
        while j<len(r):
            ls[m]=r[j]
            j+=1
            m+=1
mergesort(l)

if len(l)==1:
    print(l[0])
else:
    for i in range(len(l)-1):
        print(str(l[i])+'+',end='')
    print(str(l[-1]))