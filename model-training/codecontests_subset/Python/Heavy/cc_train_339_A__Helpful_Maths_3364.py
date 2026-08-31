# The teacher has written down the sum of multiple numbers. Pupils should calculate the sum
#  pupils can calculate a sum only if the summands follow in non-decreasing order
#  Rearrange the summans and print the sum in such a way that Xenia can calculate the sum
# Print the new sum that Xenia can count.
a=0
l=[]
user_input=list(input())
for element in user_input:
    if(element!="+"):
        l.append(element)
l=list(map(int,l))
l.sort()
for i in l:
    a+=1
    if(a==len(l)):
        print(i,end='')
    else:
        print(i,end='+')