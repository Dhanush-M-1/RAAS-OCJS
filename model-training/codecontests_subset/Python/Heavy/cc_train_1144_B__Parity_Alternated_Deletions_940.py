n = int(input())
a = list(map(int,input().split()))
even = []
odd = []
for i in a:
    if i%2==0:
        even.append(i)
    else:
        odd.append(i)
if len(even) == len(odd):
    print(0)
else:
    if len(even) > len(odd):
        ans = sum(a) - sum(odd)
        even = sorted(even,reverse = True)
        for i in range(len(odd)+1):
            ans -= even[i]
    else:
        ans = sum(a) - sum(even)
        odd = sorted(odd,reverse = True)
        for i in range(len(even)+1):
            ans -= odd[i]
    print(ans)