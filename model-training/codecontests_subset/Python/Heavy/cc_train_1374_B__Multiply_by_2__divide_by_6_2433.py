#READ ARRAY
#A = list(map(int,input().split()))
#n = int(input())
#n,m=map(int,input().split())

sixPowers = [1,
6,
36,
216,
1296,
7776,
46656,
279936,
1679616,
10077696,
60466176,
362797056]

t = int(input())
for testcase in range(t):
    A = int(input())
    i = 0
    while(A!=1):
        if(A % 6!=0):
            A = A*2
            i += 1
            if(A%6!=0):
                break
        if(A*2 in sixPowers):
            A = A*2
        else:
            A=A/6
        i += 1
    if(A!=1):
        print(-1)
    else:
        print(i)

 
