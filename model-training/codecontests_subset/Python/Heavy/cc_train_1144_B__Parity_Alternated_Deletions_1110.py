def giveMin(arr):
    oddC  = evenC = 0
    arrOdd = []
    arrEv = []
    for num in arr:
        if num%2==0:
            evenC += 1
            arrEv.append(num)
        else:
            oddC+= 1
            arrOdd.append(num)
            
    if oddC == evenC or abs(oddC-evenC)==1:
        return 0
    else:
        arrOdd.sort()
        arrEv.sort()
        if oddC > evenC:
            return sum(arrOdd[:(oddC-evenC-1)])
        else:
            return sum(arrEv[:(evenC-oddC-1)])

    

n = int(input())
arr = list(map(int, input().rstrip().split()))

print(giveMin(arr))


