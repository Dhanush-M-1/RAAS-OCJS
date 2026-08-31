##INPUT FROM FILE
# line1,line2 = map(int,f.readline().rstrip().split())
# for line in f.readlines():
#     x , y = map(int,line.rstrip().split())
# with open("input.txt",'r') as f:
#     n = int(f.readline().rstrip())
#     array = list(map(int,f.readline().rstrip().split()))
#     array1 = list(map(int,f.readline().rstrip().split()))
#     array2 = list(map(int,f.readline().rstrip().split()))

#INPUT FROM CMD
n = int(input().rstrip())
array = list(map(int,input().rstrip().split()))
array1 = list(map(int,input().rstrip().split()))
array2 = list(map(int,input().rstrip().split()))


# MAIN CODE/MAIN LOGIC
j = 0
i= 0
k = 0
array.sort()
array2.sort()
array1.sort()
while i<len(array1):
    if(array[i]==array1[j]):
        j+=1
        i+=1
    else:
        break
i = 0
while(i<len(array2)):
    if(array1[i]==array2[k]):
        k+=1
        i+=1
    else:
        break
print(array[j])
print(array1[k])










