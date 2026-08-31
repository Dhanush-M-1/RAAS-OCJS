

n = int(input())
l = []
for i in range(n):
    l.append(list(map(int,input().split())))

if (n <= 2):
    print(n)
    exit()

else:
    ans = 2

    for i in range(1 , n - 1):
        if (l[i][0] - l[i][1] > l[i - 1][0]):
            #print(l[i][0] , l[i][1] , l[i-1][0] , '-')
            ans +=1

        elif (l[i][0] + l[i][1] < l[i + 1][0]):
            l[i][0] += l[i][1]
            #print(l[i][0] , l[i][1] , l[i+1][0] , '+')
            ans +=1

        else:
            continue

    print(ans)