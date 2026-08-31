'''
ragi
'''

n = int(input())
a = [int(x) for x in input().split()]
odd = []
even = []
for elem in a:
    if elem & 1:
        odd.append(elem)
    else:
        even.append(elem)

odd.sort()
even.sort()

req = min(len(odd),len(even))
len_odd = min(0,req-len(odd))
len_even = min(0,req-len(even))


while(req):
    odd.pop()
    even.pop()
    req = req - 1
    
if len_odd!=0:
    odd.pop()
if len_even!=0:
    even.pop()
    
ans = 0
for i in odd:
    ans = ans + i

for i in even:
    ans = ans + i

print(ans)
