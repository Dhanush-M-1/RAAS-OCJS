x = input()
a1 = a2 = a3 = 0                # number of 1, 2, 3

n = len(x)
for i in range(0, n, 2):
    if (x[i] == '3'):
        a3 += 1
    elif (x[i] == '2'):
        a2 += 1
    else:
        a1 += 1

# 1         
if (a1 >= 1 and (a2 + a3) != 0):
    print('1+' * a1, end="")
elif (a1 >= 1 and (a2 + a3) == 0):
    print('1+' * (a1 - 1), end="")
    print('1')
    exit()

# 2 and 3    
if (a2 >= 1 and a3  >= 1):
    print('2+' * a2, end="")
    print('3+' * (a3 - 1), end="")
    print('3')
elif (a2 >= 1 and a3 == 0):
    print('2+' * (a2 - 1), end="")
    print('2')
else:
    print('3+' * (a3 - 1), end="")
    print('3')