n = int(input())
arr = list(map(int, input().split()))

odd = 0
even = 0
oa = []
ea = []
for i in range(n):
    if arr[i]%2==0:
        even += 1
        ea.append(arr[i])
    else:
        odd += 1
        oa.append(arr[i])

diff = abs(even-odd)
if diff==1 or diff==0:
    print(0)
else:
    ea.sort()
    oa.sort()
    mn = min(odd, even)
    if mn==odd:
        for i in range(2*mn+1):
            if i%2==0:
                ea = ea[:-1]
            else:
                oa = oa[:-1]
    else:
        for i in range(2*mn+1):
            if i%2==0:
                oa = oa[:-1]
            else:
                ea = ea[:-1]

    print(sum(ea)+sum(oa))
        
