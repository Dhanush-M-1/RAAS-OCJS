t = int(input())

def get_list():
    raw_input = input() + " "
    input_list = []
    d = 0
    for i in range(len(raw_input)):
        if raw_input[i] != " ":
            d += 1
        elif raw_input[i] == " ":
            input_list.append(int(raw_input[i-d:i]))
            d = 0
    return input_list

while t > 0:
    n = int(input())
    data = []
    for i in range(n):
        data.append(get_list())
    valid = True
    if data[0][0] < data[0][1]:
        valid = False
    for i in range(n-1):
        if data[i+1][0] - data[i][0] < 0 or data[i+1][1] - data[i][1] < 0 or data[i+1][0]-data[i][0] < data[i+1][1]-data[i][1]:
            valid = False
    if valid:
        print("YES")
    else:
        print("NO")
    
    t -= 1