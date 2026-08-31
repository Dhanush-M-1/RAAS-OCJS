
a = int(input())
s = input()

b = {'A':0, 'I':0, 'F':0}


for i in s:
    b[i] += 1
if b['I'] > 1:
    print(0)
elif b['I'] == 1:
    print(1)
else:
    print(b['A'])
	
