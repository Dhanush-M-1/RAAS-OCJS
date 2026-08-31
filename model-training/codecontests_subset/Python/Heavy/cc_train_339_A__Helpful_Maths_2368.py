a = input()
a=a.split("+")

def sort(array):
    less = []
    equal = []
    greater = []

    if len(array) > 1:
        pivot = array[0]
        for x in array:
            if x < pivot:
                less.append(x)
            if x == pivot:
                equal.append(x)
            if x > pivot:
                greater.append(x)
        
        return sort(less)+equal+sort(greater)  
    
    else:  
        return array
a=sort(a)
T=str(a[0])
if len(a)>1:
    for x in range(1,len(a)):
        T=T+"+"+str(a[x])

print(T)