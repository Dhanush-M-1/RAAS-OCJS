x=int(input())
l=[]
for i in range(x):
    l.append(list(map(int,input().split())))
for i in l:
    if (i[0]-1)/i[2]>=1:
        print(i[2])
    elif (i[1]+1)/i[2]<=1:
        print(i[2])
    else:
        print((i[1]//i[2]+1)*i[2])
