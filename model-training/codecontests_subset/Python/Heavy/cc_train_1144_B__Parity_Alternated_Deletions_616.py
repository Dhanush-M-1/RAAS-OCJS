n=int(input())
l=list(map(int,input().split()))
odd,even=[],[]
for i in range(n):
    if l[i]%2==0:
        even.append(l[i])
    else:
        odd.append(l[i])
even.sort()
odd.sort()
even.reverse()
odd.reverse()
if len(odd)==0 and len(even)>0:
    print(sum(even[1:]))
    exit()
if len(even)==0 and len(odd)>0:
    print(sum(odd[1:]))
    exit()
if abs(len(odd)-len(even))==1:
    print(0)
    exit()
if len(odd)>len(even):
    print(sum(odd[len(even)+1:]))
    exit()
if len(even)>len(odd):
    print(sum(even[len(odd)+1:]))
    exit()
print(0)