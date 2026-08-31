n = int(input())
numbers = [int(x) for x in input().split()]

odd, even = [],[]
for i in numbers:
    if i % 2:
        odd.append(i)
    else:
        even.append(i)

diff = abs(len(odd) - len(even))
if diff < 2:
    print (0)
else:
    spare = 0
    if len(odd) > len(even):
        odd = [int(x) for x in sorted(odd)]
        for i in range(diff-1):
            spare = spare + odd[i]
    else:
        even = [int(x) for x in sorted(even)]
        for i in range(diff-1):
            spare = spare + even[i]
    print (spare)
            
    
