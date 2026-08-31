def delete(array, f):
    for j in range(len(array)):
        if f == 0:  #even
            for k in range(len(array)):
                if array[k]%2 != 0:
                    array.remove(array[k])
                    f = 1
                    break
        else:   #odd
            for k in range(len(array)):
                if array[k]%2 == 0:
                    array.remove(array[k])
                    f = 0
                    break

n = int(input())
a = [int(x) for x in input().split()]
a.sort(reverse=True)
#print(a)
even = a.copy()
odd = a.copy()
#even.remove(even[0])
#print(even[0])
if a[0]%2 == 0:
    even.remove(a[0])
    flag = 0    #even
else:
    odd.remove(a[0])
    flag = 1    #odd
#for i in range(len(a)):
delete(even, flag)
delete(odd, flag)
if sum(even) < sum(odd):
    print(sum(even))
else:
    print(sum(odd))


