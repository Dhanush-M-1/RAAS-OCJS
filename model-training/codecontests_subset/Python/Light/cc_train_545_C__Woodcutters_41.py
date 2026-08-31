t = int(input())
l = [[int(x) for x in input().split()]for i in range(t)]

if t >= 3:
    count = 2
    end = l[0][0]
    begin = l[2][0]

    for i in range(1,t-2):
        if l[i][0] - l[i][1] > end:
            count += 1
            end = l[i][0]
        elif l[i][0] + l[i][1] < begin:
            count += 1
            end = l[i][0] + l[i][1]
        else:
            end = l[i][0]
        begin = l[i+2][0]
    
    if l[-2][0] - l[-2][1] > end or l[-2][0] + l[-2][1] < l[-1][0]:
        print(count+1)
    else:
        print(count)
else:
    print(t)