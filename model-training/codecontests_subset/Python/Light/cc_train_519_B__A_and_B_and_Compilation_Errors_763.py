import sys
tests, errors, i = 0, [], 0

for line in sys.stdin:
    numbers = [int(x) for x in line.strip().split()]
    if i == 0:
        tests, i = numbers[0], 1
        errors = [[0]*tests]*3
        continue
    errors[i-1] = sorted(numbers)
    i+=1


temp = errors[0]
for ls in errors[1:]:
    found = False
    for index, value in enumerate(ls):
        if temp[index] != value:
            print(temp[index])
            found = True
            break
    
    if not found:
        print(temp[-1])
    temp = ls
