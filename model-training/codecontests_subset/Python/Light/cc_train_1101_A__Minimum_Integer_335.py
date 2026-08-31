from math import ceil

def compute_minimum_int(input_data):
    for i in range(len(input_data)):
        input_data[i] = int(input_data[i])
    x = input_data[:-1]
    d = input_data[2]
    x.sort()
    if not ((d >= x[0]) and (d <= x[1])):
        return d
    z = x[1]/d
    y = ceil(x[1]/d)
    if z == y:
        y += 1
    return d*y



inputs = []
inputs_num = int(input())

while inputs_num > 0:
    input_data = input().split(' ')
    inputs.append(input_data)
    inputs_num -= 1

for i in inputs:
    print(compute_minimum_int(i))
