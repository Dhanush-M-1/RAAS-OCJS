num = input()
arr = []
count = 0

for i in range(0,len(num)):
    if num[i] == ' ':
        arr.append(int(num[count:i]))
        count = i+1
    elif  i == len(num)-1:
        arr.append(int(num[count:len(num)]))

finished = None
count = 0
using = arr[0]
dead  = 0

while finished == None:
    if using == 0 and dead < arr[1]:
        break
    elif using > 0:
        using -= 1
        dead += 1
        count += 1
    else :
        using = int(dead/arr[1])
        dead  = dead%arr[1]

print(count)

#4 2