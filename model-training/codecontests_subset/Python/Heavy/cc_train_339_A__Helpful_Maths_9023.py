
x:str =( input())
x=x.split("+")

x = [int(i) for i in x]



def mergeSort(x):
    if len(x) > 1:
        mid = len(x) // 2  # Finding the mid of the xay
        L = x[:mid]  # Dividing the xay elements
        R = x[mid:]  # into 2 halves

        mergeSort(L)  # Sorting the first half
        mergeSort(R)  # Sorting the second half

        i = j = k = 0

        # Copy data to temp xays L[] and R[]
        while i < len(L) and j < len(R):
            if L[i] < R[j]:
               x[k] = L[i]
               i += 1
            else:
                x[k] = R[j]
                j += 1
            k += 1

        # Checking if any element was left
        while i < len(L):
            x[k] = L[i]
            i += 1
            k += 1

        while j < len(R):
            x[k] = R[j]
            j += 1
            k += 1
    return x
x= mergeSort(x)
if(x.__len__()>1):
    for i in range(0,x.__len__()-1):
        print( x[i],end="+")
    print(x[x.__len__()-1],end="")

else:
   print(x[0])

