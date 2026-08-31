n=int(input())
a=sorted([int(x) for x in input().split()],key=int)
b=sorted([int(x) for x in input().split()],key=int)
c=sorted([int(x) for x in input().split()],key=int)
i=0     
while i<n-1 and a[i]==b[i]:
        i+=1
print(a[i])
i=0
while i<n-2 and b[i]==c[i]:
        i+=1
print(b[i])
