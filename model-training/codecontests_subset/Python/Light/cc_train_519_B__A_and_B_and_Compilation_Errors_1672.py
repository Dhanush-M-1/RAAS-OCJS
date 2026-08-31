n = int(input())

num = sorted([int(i) for i in input().split()])
num1 = sorted([int(i) for i in input().split()])
num2 = sorted([int(i) for i in input().split()])

for i in range(len(num1)):
    if num[i] != num1[i]:
        print(num[i])
        break
    
else:
    print(num[-1])

for j in range(len(num2)):
    if num1[j] != num2[j]:
        print(num1[j])
        break
    
else:
    print(num1[-1])


    
        