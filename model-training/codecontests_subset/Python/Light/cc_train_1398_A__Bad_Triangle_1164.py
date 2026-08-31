n = int(input())
result = []
for i in range(n):
    num = int(input())
    l = list(map(int, input().split()))
    maximum = max(l)
    flag = 0 
    for i in range(len(l) - 2):
        a = l[i]
        b = l[i+1]
        s = a+b
        if s <= maximum:
            flag = 1
            result.append([i+1, i+2, num])
            break
    if flag == 0:
        result.append(0)

else:
    for i in result:
        if i == 0 :
            print(-1)
        else:
            for ele in i:
                print(ele, end = ' ')
            print()
