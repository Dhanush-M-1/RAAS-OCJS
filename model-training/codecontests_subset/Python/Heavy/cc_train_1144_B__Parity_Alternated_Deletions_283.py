n=int(input())
arr=list(map(int,input().split()))

def parity(arr):
    odd=[]
    even=[]
    for i in arr:
        if (i%2==0):
            even.append(i)
        else:
            odd.append(i)

    if (len(odd)>=len(even)):
        while (len(even)!=0):
            odd.remove(max(odd))
            even.remove(max(even))
        if (len(odd)!=0):
            odd.remove(max(odd))
        return sum(odd)+sum(even)

    else:
        while (len(odd)!=0):
            even.remove(max(even))
            odd.remove(max(odd))
        if (len(even)!=0):
            even.remove(max(even))
        return sum(odd)+sum(even)
print (parity(arr))