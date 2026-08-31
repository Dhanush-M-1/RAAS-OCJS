n = input()
a = input()
key_value = [["1", 0]]
key = False
for i in range(len(a)-1):
    res = ""
    res += a[i] + a[i+1]
    for j in range(len(key_value)):
        if res == key_value[j][0]:
            key = True
            break
    if key == True:      
        key_value[j][1] +=1
        key = False
    else:
        key_value.append([res, 1])
max = 0         
for t in range(len(key_value)):
    if max < key_value[t][1]:
        max = key_value[t][1]
        index = key_value.index(key_value[t])
print(key_value[index][0])