s = input()

def check_num(s):
    numlist = []
    for char in s:
        if char.isnumeric():
            numlist.append(char)
    return numlist
def check_order(alist):
    for passnum in range(len(alist)-1,0,-1):
        for i in range(passnum):
            if alist[i]>alist[i+1]:
                temp = alist[i]
                alist[i] = alist[i+1]
                alist[i+1] = temp
    output = ""
    for j in range(len(alist)):
        output += alist[j]
        if j != len(alist)-1:
            output += "+"
    return output
        


print(check_order(check_num(s)))