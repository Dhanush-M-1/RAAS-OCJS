lst=input()
if len(lst)==1:
    output = lst
else:
    lst=lst.split('+')
    while 0==0:
        for i in range(len(lst)-1):
            if int(lst[i]) > int(lst[i+1]):
                cons = lst[i]
                lst[i] = lst[i+1]
                lst[i+1] = cons
        count = 0
        for i in range(len(lst)-1):
            if lst[i]>lst[i+1]:
                break;
            elif i==len(lst)-2:
                count = 1
        if count == 1:
            break;
    output=lst[0]
    for i in lst[1:]:
        output += '+' + i
print(output)