string = str(input(""))
temp = string.split("+")

#insertion sort
def insertionSort(alist):
   for index in range(1,len(alist)):

     currentvalue = alist[index]
     position = index

     while position>0 and alist[position-1]>currentvalue:
         alist[position]=alist[position-1]
         position = position-1

     alist[position]=currentvalue

def printV(alist):
    temp2 = ""
    for i in range (0, len(alist)):
        temp2 += str(alist[i])
        if i != len(alist)-1:
            temp2 += "+"
    print(temp2)


insertionSort(temp)
printV(temp)



