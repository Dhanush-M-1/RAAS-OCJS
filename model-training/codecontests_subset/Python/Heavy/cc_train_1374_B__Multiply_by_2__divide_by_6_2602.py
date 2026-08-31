
def sum(num):
    num = str(num)
    su = 0
    for i in range(len(num)):
        su = su + int(num[i])
    return su
#print(sum(12345))
n = int(input())
count = 0
for i in range(n):
    num = int(input())
    #arr.append(x)
    #num = arr[i]
    while(num>=1):

        if num == 1:
            print(count)
            count = 0
            break
        elif num == 2:
            print('-1')
            count = 0
            break
        elif num %2==0 and num%3==0:
            num = num//6
            count += 1
        elif num %6!=0 and num%4 == 0:
            print('-1')
            count = 0
            break
        else:
            num = num*2
            count += 1
