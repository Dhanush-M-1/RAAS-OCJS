
def partition(arr, left, right):
    pivot = arr[right]
    idx = left - 1

    for i in range(left,right):
   
        if(arr[i]<=pivot):
            idx = idx + 1
            arr[i],arr[idx] = arr[idx], arr[i]


    arr[right], arr[idx+1] = arr[idx+1],arr[right]
    return idx+1

       


def quickSort(arr,left, right):
    if(left<right):
        part = partition(arr, left, right)
        quickSort(arr,left, part-1)
        quickSort(arr, part, right)
    
    return arr

arrNum = input().split("+")
if(len(arrNum)==1):
    print(int(arrNum[0]))

else:
    arrInt = []
    for i in arrNum:
        arrInt.append(int(i))

    res = quickSort(arrInt,0, len(arrInt)-1)
    ans = ''
    for i in range(0,len(res)):
        if(len(ans)>0):
            ans = ans + "+"+str(res[i])
        else:
            ans = ans + str(res[i])


    print(ans)




