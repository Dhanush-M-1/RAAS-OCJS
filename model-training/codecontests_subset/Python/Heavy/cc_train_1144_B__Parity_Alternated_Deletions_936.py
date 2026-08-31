import math
n = int(input())

arr = list(map(int, input().split()))

even = []
odd = []
for i in arr:
    if i%2==0:
        even.append(i)
    else:
        odd.append(i)

if math.fabs(len(even) - len(odd)) > 1:
    even = sorted(even)
    odd = sorted(odd)
    lacking = 0
    answer = 0
    if len(even) < len(odd):
       lacking += len(odd) - len(even) - 1
       for i in range(lacking):
           answer += odd[i]
    else:
        lacking += len(even) - len(odd) - 1
        for i in range(lacking):
            answer += even[i]
    print(answer)
else:
    print("0")
