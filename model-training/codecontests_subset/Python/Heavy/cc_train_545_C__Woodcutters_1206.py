n = int(input())
arr = []
if n > 1:
    count = 2
else:
    count = 1
for i in range(n):
    x, h = map(int, input().split())
    tup = (x, h)
    arr.append(tup)
occupied = []
for i in range(n-1):
    if i > 0:
        left_temp_tup = (arr[i][0] - arr[i][1], arr[i][0]) #range in left
        right_temp_tup = (arr[i][0], arr[i][0] + arr[i][1]) #range in right
        if left_temp_tup[0] > occupied[len(occupied)-1][1]:
            occupied.append(left_temp_tup)
            count += 1
        elif right_temp_tup[1] < arr[i+1][0]:
            occupied.append(right_temp_tup)
            count += 1
        else:
            a = (arr[i][0], arr[i][0])
            occupied.append(a)
    else:
        a = (arr[0][0] - arr[0][1], arr[0][0]) #initial condition 
        occupied.append(a)
print(count)