n = int(input())
apples = []
apples[0:n-1] = input().split()
weight = []
sum = 0
for i in range(n):
    sum += int(apples[i])
    weight.append(int(apples[i]))
count100 = 0
if sum/100%2:
    print("NO")
else:
    tk,os = 0,0
    for i in weight:
        if (i == 200):
            if tk > os:
                os += i
            else:
                tk += i
        else:
            count100 += 1
    #print(tk,os,abs(tk - os)/100)
    count100 -= abs(tk - os)/100
    #print(count100)
    if (count100 >= 0):
        tk = os
        if (count100%2 == 0):
            print("YES")
        else:
            print("NO")
    else:
        print("NO")