n = int(input())
arr = [int(x) for x in input().split()]
even = []
odd = []
answer = 0
for number in arr:
    if number % 2 == 0:
        even.append(number)
    else:
        odd.append(number)
difference = int(abs(len(even) - len(odd)))
if difference != 1:
    if len(even) > len(odd):
        even.sort()
        for elem in range(difference - 1):
            answer += even[elem]
    else:
        odd.sort()
        for elem in range(difference - 1):
            answer += odd[elem]
print(answer)
