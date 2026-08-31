t=int(input())
a=sorted(list(map(int,input().split())))
l_even=[]
l_odd=[]
for i in a:
    if i%2==0:
        l_even.append(i)
    else:
        l_odd.append(i)
l_even.reverse()
l_odd.reverse()
if len(l_even)>len(l_odd):
    b=l_even[0]
    l_even.remove(b)
else:
    b=l_odd[0]
    l_odd.remove(b)

if b%2==0:
    for i in range(t):
        if i%2==0:
            if len(l_odd)>0:
                l_odd.remove(l_odd[0])
            else:
                break
        else:
            if len(l_even)>0:
                l_even.remove(l_even[0])
            else:
                break
else:
    for i in range(t):
        if i%2==0:
            if len(l_even)>0:
                l_even.remove(l_even[0])
            else:
                break
        else:
            if len(l_odd)>0:
                l_odd.remove(l_odd[0])
            else:
                break
lst=l_even+l_odd
print(sum(lst))