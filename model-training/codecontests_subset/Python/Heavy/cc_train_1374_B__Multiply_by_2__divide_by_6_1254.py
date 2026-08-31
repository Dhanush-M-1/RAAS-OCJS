def one_get_not_get(arr):
    
    for i in range(len(arr)):
        j = 0
        count = 0
        count1 = 0
        value = arr[i]
        while(j < value*6):
            if arr[i] % 6 == 0:
                arr[i] = int(arr[i]/6)
                count += 1
                count1 -= 1
            elif (arr[i] - 6) == 2:
                print(-1)
                break
            elif count1 > 6:
                print(-1)
                break
            elif arr[i] == 1:
                print(count)
                break
            else:
                arr[i] = arr[i]*2
                count += 1
                count1 += 1
            j += 1
 
if __name__ == '__main__':
    t = int(input())
    arr = []
    for i in range(t):
        n = int(input())
        arr.append(n)
    one_get_not_get(arr)