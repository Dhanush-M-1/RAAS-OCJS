n = int(input())
a = list(map(int,input().split()))
odd = []
even = []
sum = 0
for i in range(n):
    sum+=a[i]
    if(a[i]%2==0):
        even.append(a[i])
    else:
        odd.append(a[i])
if(len(odd)>1):
    odd.sort()
if(len(even)>1):
    even.sort()
if(len(odd)>len(even)):
    for i in range(len(even)-1,-1,-1):
        sum-=even[i]
    for i in range(len(odd)-1,len(odd)-len(even)-2,-1):
        sum-=odd[i]
    print(sum)
elif(len(odd)<len(even)):
    for i in range(len(odd)-1,-1,-1):
        sum-=odd[i]
    for i in range(len(even)-1,len(even)-len(odd)-2,-1):
        sum-=even[i] 
    print(sum)
else:
    print(0)

