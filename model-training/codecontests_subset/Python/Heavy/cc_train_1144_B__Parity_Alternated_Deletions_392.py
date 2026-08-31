n=int(input())
Ar=[int(x) for x in input().split()]
Even_Array=[]
Odd_Array=[]
for i in Ar:
    if i%2==0:
        Even_Array.append(i)
    else:
        Odd_Array.append(i)
Len_Odd_Array=len(Odd_Array)
Len_Even_Array=len(Even_Array)
Odd_Array.sort()
Even_Array.sort()
# print(Even_Array)
# print(Odd_Array)
if Len_Even_Array-Len_Odd_Array>0:
    n=Len_Even_Array-Len_Odd_Array
    if n!=0:
        print(sum(Even_Array[:n-1]))
    else:
        print(0)
else:
    n=Len_Odd_Array-Len_Even_Array
    if n!=0:
        print(sum(Odd_Array[:n-1]))
    else:
        print(0)
