n=int(input())
xold,hold=map(int, input().split(' '))
k=1
flag=True
for i in range(n-1):
    xnew, hnew=map(int, input().split(' '))
    if flag==False:
        if xold+hold<xnew:
            k+=1
            xold=xold+hold
    if xold<xnew - hnew:
        k+=1
        flag=True
    else:
        flag=False
    xold,hold=xnew, hnew
if flag==False:
    k+=1
print(k)

