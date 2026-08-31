n, k = [int(i) for i in input().split()]

books = [[int(i) for i in input().split()] for i in range(n)]
#b00 = []
b01 = []
b10 = []
b11 = []
b00c, b01c, b10c, b11c = 0,0,0,0

index = 0

for book in books:
    if book[1] == 1:
        if book[2] == 1:
            b11.append(book[0])
        else:
            b10.append(book[0])
    else:
        if book[2] == 1:
            b01.append(book[0])
b11.sort(), b10.sort(), b01.sort()

b0_index = 0
b1_index = 0

time = 0

if len(b11) > 0:
    b1Out = False
else:
    b1Out = True
if len(b01) > 0 and len(b10) > 0:
    b0Out = False
else:
    b0Out = True


while b0_index + b1_index < k:
    if not any([b1Out, b0Out]):
        if b11[b1_index] < b01[b0_index] + b10[b0_index]:
            time += b11[b1_index]
            b1_index += 1
            if b1_index > len(b11) - 1:
                b1Out = True
        else:
            time += b01[b0_index] + b10[b0_index]
            b0_index += 1
            if b0_index > len(b01) - 1 or b0_index > len(b10) - 1:
                b0Out = True
    else:
        if b1Out and b0Out:
            time = -1
            break
        else:
            if b1Out:
                time += b01[b0_index] + b10[b0_index]
                b0_index += 1
                if b0_index == len(b01) or b0_index == len(b10):
                    b0Out = True
            else:
                time += b11[b1_index]
                b1_index += 1
                if b1_index == len(b11):
                    b1Out = True


print(time)
