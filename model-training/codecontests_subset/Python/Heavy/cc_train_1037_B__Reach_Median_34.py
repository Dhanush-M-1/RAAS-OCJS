#NGUYEN NGOC THUA

##########################
import sys


line1 = str(sys.stdin.readline())
n = int(line1.split()[0])
s = int(line1.split()[1])
#print(n, s)
arr = []
line2 = str(sys.stdin.readline())
for i in line2.split():
    arr.append(int(i))
    
arr.sort()
#print(arr)

step = 0

if s >= arr[int((n-1)/2)]:
    step += s - arr[int((n-1)/2)]

    #print("step", step)
    arr[int((n-1)/2)] = s
    i = int((n-1)/2)

    while (i < n-1) and (arr[i] > arr[i+1]):
        step += arr[i] - arr[i+1]
        arr[i+1] = arr[i]
        i += 1
            #print("step", step)
    #print(arr)
else:
    step += arr[int((n-1)/2)] - s

    #print("step", step)
    arr[int((n-1)/2)] = s
    i = int((n-1)/2)
    while (i > 0) and (arr[i-1] > arr[i]):
        #print("i", i)
        step += arr[i-1] - arr[i]
        arr[i-1] = arr[i]
        i -= 1
            #print("step", step)
#print(arr)
print(step)

