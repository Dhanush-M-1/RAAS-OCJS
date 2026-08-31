n=int(input())
data=[[int(x) for x in input().split()] for i in range(n)]+[[0,0]]
if n>2:
    i=2
    left=data[1][0]-data[0][0]
    right=data[2][0]-data[1][0]
    for j in range(1,n-1):
        if left>data[j][1]:
            i+=1
            left=right
        elif right>data[j][1]:
            i+=1
            left=right-data[j][1]
        else:
            left=right
        right=data[j+2][0]-data[j+1][0]
    print(i)
elif n==2:
    print(2)
else:
    print(1)