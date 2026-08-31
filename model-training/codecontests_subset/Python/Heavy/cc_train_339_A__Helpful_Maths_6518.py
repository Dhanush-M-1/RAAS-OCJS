st = input()
one_count = 0
two_count = 0
three_count = 0;

for i in range(len(st)):
    if(st[i] == '1'):
        one_count = one_count + 1
    elif(st[i] == '2'):
        two_count = two_count + 1
    elif(st[i] == '3'):
        three_count = three_count + 1
    else:
        one_count = one_count + 0;

fin = ""
if(len == 1):
    print(st)
else:
    for i in range(one_count):
        fin = fin + "1+"
    for i in range(two_count):
        fin = fin + "2+"
    for i in range(three_count):
        fin = fin + "3+"
print(fin[0:len(fin)-1])    
        