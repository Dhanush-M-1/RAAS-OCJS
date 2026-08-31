n = int(input())
l = input().split()
odd,even = [],[]
for x in l:
    if int(x) % 2 == 0:
        even.append(int(x))
    else:
        odd.append(int(x))
even = sorted(even)
odd = sorted(odd)
len_odd = len(odd)
len_even = len(even)

if len_odd > len_even:
    if len(even) == 0:
        print(sum(odd) - odd[-1])
    else:
        print(sum(odd[ : len_odd-(len_even+1)]))
elif len(even) > len(odd):
    if len(odd) == 0:
        print(sum(even) - even[-1])
    else:
        print(sum(even[ : len_even-(len_odd+1)]))
else:
    print(0)