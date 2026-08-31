n = int(input())


final = []
for i in range(n):
    p, h = map(int, input().split())
    final.append([p, h])

if len(final) == 1:
    print(1)

else:
    count = 2
    for i in range(1, len(final) - 1):
        if final[i][0] - final[i][1] > final[i - 1][0]:
            count += 1
        elif final[i][0] + final[i][1] < final[i + 1][0]:
            count += 1
            final[i][0] += final[i][1]
     

    print(count)

        
        
        
    
