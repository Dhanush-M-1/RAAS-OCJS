n=int(input())
m=[[int(x) for x in input().split()] for i in range(n)]
a=2
if n<=2:
    print(n)
else:
    for i in range(n-2):
        if m[i+1][1]<m[i+1][0]-m[i][0]:
            a+=1
        elif m[i+1][1]<m[i+2][0]-m[i+1][0]:
            a+=1
            m[i+1][0]+=m[i+1][1]
    print(a)
