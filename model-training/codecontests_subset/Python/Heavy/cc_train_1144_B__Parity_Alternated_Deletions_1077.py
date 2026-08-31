n=int(input())
a=input().split()
a=list(a)
even=[]
odd=[]
for i in range(n):
    a[i]=int(a[i])
for i in range(n):
    if a[i]%2==0:
        even.append(a[i])
    else:
        odd.append(a[i])
odd.sort()
even.sort()
#print(*odd)
#print(*even)
sum=0
if len(odd)>len(even):
    diff=len(odd)-len(even)
    if(diff==1):
        print(0)
    #print(diff)
    else:
        for i in range(diff-1):
            sum+=odd[i]
        print(sum)
elif len(odd)<len(even):
    diff=len(even)-len(odd)
    if(diff==1):
        print(0)
    #print(diff)
    else:
        for i in range(diff-1):
            sum+=even[i]    
        print(sum)
else:
    print(0)
    
    
