num = int(input())
inputs = []
raw = input().split()
inputs = [int(item) for item in raw]
inputs.sort()
even = 0
odd = 0
for item in inputs:
    if(item % 2 == 0):
        even += 1
    else:
        odd += 1
result = 0
if(even - odd > 1):
    temp = even - odd - 1
    for item in inputs:
        if(item % 2 == 0 and temp > 0):
            result += item
            temp -= 1
elif(odd - even > 1):
    temp = odd - even - 1
    for item in inputs:
        if(item % 2 != 0 and temp > 0):
            result += item
            temp -= 1
print(result)
    