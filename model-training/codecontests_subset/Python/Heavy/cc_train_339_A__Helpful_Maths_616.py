input=input('')

length=1
for char in input:
    if char=='+':
        length=length+1

out=[0 for x in range(length)]

def flag_sort(array,length):
    blue_pointer=0
    red_pointer=length
    temp=0
    i=0
    while i<red_pointer:
        if array[i]==1:
            temp=array[blue_pointer]
            array[blue_pointer]=array[i]
            array[i]=temp
            blue_pointer=blue_pointer+1
            i=i+1
        if array[i]==2:
            i=i+1
        if array[i]==3:
            temp=array[red_pointer]
            array[red_pointer]=array[i]
            array[i]=temp
            red_pointer=red_pointer-1

    return array

for index in range(0,2*length,2):
    out[index//2]=input[index]

out.sort()
string=''
for i in range(length-1):
    string=string+out[i]+'+'
string=string+out[length-1]
print(string)
