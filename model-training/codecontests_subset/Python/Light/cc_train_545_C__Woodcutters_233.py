n = int(input())
a = []
b = []
for i in range(n):
    x,h = map(int,input().split())
    a.append(x)
    b.append(h)
if len(a) == 1:
    r = 1
else:
    r = 2
for i in range(1,len(a)-1):
    if a[i]-b[i]>a[i-1]:
        r+=1


    elif a[i]+b[i]<a[i+1]:
        a[i] = a[i] + b[i]
        r += 1
    
        
        
print (r)

