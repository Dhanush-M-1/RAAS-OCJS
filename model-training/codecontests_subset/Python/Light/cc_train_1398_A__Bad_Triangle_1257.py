testcases = int(input())
for testcase in range(testcases):
    n = int(input())
    temparr = input()
    temparr = temparr.split()
    arr = []
    
    for i in temparr:
        arr.append(int(i))
    l1 = 0
    l2 = 1 
    l3 = n - 1 
    flag = 0 
    if arr[l1] + arr[l2] <=  arr[l3]:
        flag = 1 
    if flag == 0:
        print(-1)
    else:
        print("1 2 " + str(n))
    
    
    
    
    
    