

ve1 = []
ve2 = []
ve3 = []
s = input()
n, k = map(int,s.split(' '))
num1 = 0
num2 = 0
for i in range(0,n):
    s = input()
    t, a, b = map(int, s.split(' '))
    if(a & b):
        ve3.append(t)
        num1 = num1 + 1
        num2 = num2 + 1
    elif(a == 0 and b == 1):
        ve2.append(t)
        num2 = num2 + 1
    elif(a == 1 and b == 0):
        ve1.append(t)
        num1 = num1 + 1
ve1.sort()
ve2.sort()
ve3.sort()
if(num1 < k or num2 < k):
    print(-1)
    exit()
num = 0
num1 = 0
num2 = 0
Sum = 0
while(num < k):
    if(num1 < len(ve1) and num1 < len(ve2) and num2 < len(ve3)):
        if(ve1[num1] + ve2[num1] <= ve3[num2]):
            Sum = Sum + ve1[num1] + ve2[num1]
            num1 = num1 + 1
        else:
            Sum = Sum + ve3[num2]
            num2 = num2 + 1
        num = num + 1
    else:
        break
if(num == k):
    print(Sum)
    exit()
if(num2 < len(ve3)):
    while(num < k):
        Sum = Sum + ve3[num2]
        num2 = num2 + 1
        num = num + 1
else:
    while(num < k):
        Sum = Sum + ve1[num1] + ve2[num1]
        num1 = num1 + 1
        num = num + 1

print(Sum)