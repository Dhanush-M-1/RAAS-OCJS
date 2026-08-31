n=int(input())
a=[]
for i in range(n):
    x,h=[int(x) for x in input().split()]
    a.append((x,h))
sum=2
y=a[0][0]
for i in range(1,len(a)-1):
    if a[i-1][0]<a[i][0]-a[i][1]:

        if y<a[i][0]-a[i][1]:
            y=a[i][0]
            sum += 1
        else:
            if a[i][0]+a[i][1]<a[i+1][0]:
                sum+=1
                y=a[i][0]+a[i][1]

    elif a[i][0]+a[i][1]<a[i+1][0]:
        sum+=1
        y=a[i][0]+a[i][1]
    else:
        sum+=0
if n!=1:

    print(sum)
else:
    print(1)
