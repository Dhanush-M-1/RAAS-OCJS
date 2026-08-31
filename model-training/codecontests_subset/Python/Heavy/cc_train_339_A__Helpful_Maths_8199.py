inp = input()

lst = [0,0,0]

for char in inp:
    if char != '+':
        lst[int(char) - 1] += 1

del inp

countp = sum(lst) - 1
countn = 0

for i in range(lst[0]):
    print('1',end='')
    if(countn != countp):
        print('+',end='')
        countn += 1
for i in range(lst[1]):
    print('2',end='')
    if(countn != countp):
        print('+',end='')
        countn += 1
for i in range(lst[2]):
    print('3',end='')
    if(countn != countp):
        print('+',end='')
        countn += 1
        
del countn
del countp
del lst