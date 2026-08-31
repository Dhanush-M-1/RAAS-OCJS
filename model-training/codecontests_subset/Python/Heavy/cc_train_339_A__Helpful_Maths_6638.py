in_string = input().split('+')
# print(in_string)
x = 0
y = 0
z = 0
for i in range(0,len(in_string)):
    if in_string[i] == '1':
        x += 1
    elif in_string[i] == '2':
        y += 1
    else:
        z += 1
# print(x)
# print(y)
# print(z)
sum = [0]*(x+y+z)
# print(sum)
final = ""
for i in range(0,x):
    sum[i] = 1
    # print(sum)
for i in range(x,x+y):
    sum[i] = 2
    # print(sum)
for i in range(x+y,x+y+z):
    sum[i] = 3
    # print(sum)
for i in range(0,len(sum)):
    final = final + str(sum[i]) + "+"
final = final[:len(final)-1]
print(final)