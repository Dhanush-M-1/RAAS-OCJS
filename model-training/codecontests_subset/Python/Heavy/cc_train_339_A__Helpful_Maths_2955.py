lis = []
second_lis = []
n = input()
if len(n) > 1:
    for i in range(len(n)):
        lis.append(n[i])
    lis.sort()
    m = "".join(lis)
    #index_1 = m.find('1')
    if m.find('1') > -1:
        index_1 = m.find('1')
        for nums in range(index_1, len(m)):
            second_lis.append(m[nums])
        #print(second_lis)
        output = '+'.join(second_lis)
        #print(index_1)
        #print(lis)
        print(output)
    elif m.find('2') > -1:
        index_1 = m.find('2')
        for nums in range(index_1, len(m)):
            second_lis.append(m[nums])
        #print(second_lis)
        output = '+'.join(second_lis)
        #print(index_1)
        #print(lis)
        print(output)
    else:
        index_1 = m.find('3')
        for nums in range(index_1, len(m)):
            second_lis.append(m[nums])
        #print(second_lis)
        output = '+'.join(second_lis)
        #print(index_1)
        #print(lis)
        print(output)
            
else:
    print(n)