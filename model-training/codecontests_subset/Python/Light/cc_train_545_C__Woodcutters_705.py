n=int(input())
cord=[]
h=[]
for i in range(n):
    l=list(map(int,input().split()))
    cord.append([l[0],l[0]])
    h.append(l[1])
count=0
for j in range(n):
    if j==0:
        cord[j][0]=cord[j][0]-h[j]
        count=count+1
    elif j==n-1:
        cord[j][1]=cord[j][1]+h[j]
        count=count+1
    else:
        if cord[j][0]-h[j]>cord[j-1][1]:
            cord[j][0]=cord[j][0]-h[j]
            count=count+1
        elif cord[j][1]+h[j]<cord[j+1][0]:
            cord[j][1]=cord[j][1]+h[j]
            count=count+1

print(count)