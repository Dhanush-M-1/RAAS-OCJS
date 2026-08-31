n = int(input())
a = [int(x) for x in input().split()]
even = []
odd = []
for i in a:
    if i%2==0:
        even.append(i)
    else:
        odd.append(i)


lene = len(even)
leno = len(odd)
ans = 0

if abs(lene-leno)<2:
    print(0)

elif lene>leno:
    n = 0
    while n!=lene-leno-1:
        k = min(even)
        ans+=k
        even.remove(k)
        n+=1
    print(ans)

else:
    n = 0
    while n!=leno-lene-1:
        k = min(odd)
        ans+=k
        odd.remove(k)
        n+=1
    print(ans)