import sys
amount = int(input())
array = [int(s) for s in input().split()]
even = []
odd = []
for i in range(len(array)):
    if array[i] % 2:
        odd.append(array[i])
    else:
        even.append(array[i])
odd = sorted(odd)
even = sorted(even)
#print(odd, even)
sum_1 = 0
sum_2 = 0
if abs(len(odd) - len(even)) == 1 or len(odd) == len(even):
    print(0)
    sys.exit(0)
if len(odd) > len(even):
    print(sum(odd[:-len(even) - 1]))
else:
    print(sum(even[:-len(odd) - 1]))
       
#print(min(sum_1, sum_2))