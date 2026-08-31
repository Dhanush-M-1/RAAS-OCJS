N = int(input())
ls = list(map(int, input().split()))
even = []
odd = []
for i in ls:
    if i%2: odd.append(i)
    else: even.append(i)
least = max(0, abs(len(even)-len(odd))-1)
if least==0: print(0)
else:
    if len(odd)>len(even):
        odd.sort()
        odd = odd[:least]
        Sum = 0
        for i in odd:
            Sum+=i
        print(Sum)
    elif len(even)>len(odd):
        even.sort()
        even = even[:least]
        Sum = 0
        for i in even:
            Sum+=i
        print(Sum)
