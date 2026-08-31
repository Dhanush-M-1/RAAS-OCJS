test = int(input())
test_arr = []
import math
def factors(n):
    arr = {}
    flag = 0
    while(n%2==0):
        if str(2) in arr:
            arr['2'] = arr['2']+1
        else:
            arr['2'] = 1
        n = n//2
    while n%3==0:
        if str(3) in arr:
            arr[str(3)] = arr[str(3)]+1
        else:
            arr[str(3)] = 1
        n = n//3
    if n>2:
        flag=1
    
    return (arr,flag)

for _ in range(test):
    n = int(input())
    sol = factors(n)
    arr = sol[0]
    flag = sol[1]
    num = -1
    
    count2,count3 = 0,0
    for k,v in arr.items():
        if str(2)==k:
            count2 = arr[str(2)]
        if str(3)==k:
            count3 = arr[str(3)]
    if count3<count2:
        flag=1

    if flag==0:
        num = (count3-count2) + count3
    test_arr.append(num)
for t in test_arr:
    print(t)