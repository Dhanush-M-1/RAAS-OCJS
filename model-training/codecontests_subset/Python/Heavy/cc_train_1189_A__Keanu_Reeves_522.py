def good(string):
    length = len(string)
    count = 0
    for i in string:
        if i=='0':
            count+=1
    if count == (length-count):
        return False
    else:
        return True
data =[]
def func(string):
    if good(string):
        data.append(string)
        return data
    count1 = 0
    count0 = 0
    for i in range(len(string)):
        if string[i]=='1':
            count1+=1
        else:
            count0+=1
        if count1==count0:
            data.append(string[:i])
            if good(string[i:]):
                data.append(string[i:])
                return data
            else:
                func(string[i:])
        
n = int(input())
string = input()
if n==1:
    print(1)
    print(string)
else:
    a = func(string)
    print(len(a))
    for i in a:
        print(i,end=" ")
