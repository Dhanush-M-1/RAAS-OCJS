T = int(input())
massiv_i = []
for i in range(T):
    n = int(input())
    massiv_j = []
    for j in range(n):
        s = input()
        inputs = s.split(' ')
        inputs = list(map(lambda x: int(x), inputs))
        massiv_j.append(inputs)
    massiv_i.append(massiv_j)
    
for data in massiv_i:
    init_data_item = data[0]
    if len(data) > 1:
        continuum_counter = 0
        for data_item in data[1:]:
            if (data_item[0] >= data_item[1]) & (data_item[1] >= 0) \
            & (init_data_item[0] >= init_data_item[1]) & (init_data_item[1] >= 0) \
            & (data_item[0] >= init_data_item[0]) & (data_item[1] >= init_data_item[1]) \
            & ((data_item[0] - init_data_item[0]) >= (data_item[1] - init_data_item[1])):
                continuum_counter += 1
            init_data_item = data_item
        if continuum_counter == (len(data) - 1):
            print("YES")
        else:
            print("NO")
    else:
        if (init_data_item[0] >= init_data_item[1]) & (init_data_item[1] >= 0):
            print("YES")
        else:
            print("NO")