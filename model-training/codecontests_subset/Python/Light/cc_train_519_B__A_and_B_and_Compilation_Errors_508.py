n = int(input())
i=0
data = list()
while i < 3:
    num = input()
    arr = []
    counting = 0

    for m in range(0, len(num)):
        if num[m] == ' ':
            arr.append(int(num[counting:m]))
            counting = m + 1
        elif m == len(num) - 1:
            arr.append(int(num[counting:len(num)]))
    arr.sort()
    data.append(arr)
    i+=1

for m in range(0,len(data)-1):
    for n in range(len(data[m])):
        if n == len(data[m])-1:
            print(data[m][len(data[m]) - 1])
        elif data[m][n] != data[m+1][n]:
            print(data[m][n])
            break

