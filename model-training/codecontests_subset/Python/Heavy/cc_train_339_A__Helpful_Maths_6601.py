

def sort(alist):
    iteration = 0
    while iteration < len(alist):
        lowestindex = iteration
        i = iteration
        while i < len(alist):
            if (alist[i]) < (alist[lowestindex]):
                lowestindex = i
            i += 1
        temp = alist[lowestindex]
        alist[lowestindex] = alist[iteration]
        alist[iteration] = temp
        iteration += 1
    return alist


s = input()
s = s.split("+")
s = list(map(int, s))
s = sort(s)
printstring = ""
i = 0
while i < len(s):
    printstring += str(s[i])
    if i < len(s)-1:
        printstring += "+"
    i += 1

print(printstring)

