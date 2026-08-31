num = input()
c=''
ones=0
twos=0
threes=0
if len(num)==1:
    print(num)
else:

    for token in num:
        if token =='1':
            ones+=1
        elif token =='2':
            twos +=1
        elif token =='3':
            threes +=1
    for i in range (ones):
        if c =='':
            c += '1'
        else:
            c += '+1'
    for j in range(twos):
        if c =='':
            c += '2'
        else:
            c += '+2'

    for k in range(threes):
        if c =='':
            c += '3'
        else:
            c += '+3'
print(c)