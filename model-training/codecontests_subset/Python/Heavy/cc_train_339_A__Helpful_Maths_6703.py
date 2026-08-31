import math
s=str(input()).split('+')
a=[]
for i in range(0,len(s)):
    a.append(int(s[i]))
def merge(a,p,q,r): 
    left=[a[i] for i in range(p,q+1)]
    right=[a[i] for i in range(q+1,r+1)]
    left.append(math.inf)
    right.append(math.inf)
    i=j=0
    for k in range(p,r+1):
        if left[i]<=right[j]:
            a[k]=left[i]
            i+=1
        else:
            a[k]=right[j]
            j+=1

def merge_sort(a,p,r):
    if p<r:
        q=(p+r)//2
        merge_sort(a,p,q)
        merge_sort(a,q+1,r)
        merge(a,p,q,r)
    return a
a=merge_sort(a,0,len(a)-1)
c=[]
for i in range(0,len(a)):
    c.append(str(a[i]))
b='+'
print(b.join(c))