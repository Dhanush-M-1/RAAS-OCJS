a = input()
b = int(input())
array = []
x = 0
y = 0
for i in range(b):
    array.append(input())
letter1 = a[0]
letter2 = a[1]
for i in array:
    b_letter1 = i[0]
    b_letter2 = i[1]
    if i == a:
        x = 1
        y = 1
    if letter1 == b_letter2:
        x = 1
    if letter2 == b_letter1:
        y = 1
if x == 1 and y == 1:
    print("YES")
else:
    print("NO")

