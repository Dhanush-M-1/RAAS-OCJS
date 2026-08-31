n=input().split(' ')
m=input().split(' ')
n=list(map(int,n))
m=list(map(int,m))
m.sort()
global count
count=0
def med(x,y):
    global count
    if len(y)==1:
        if y[0]>x[1]:
            count+=y[0]-x[1]
            y[0]=x[1]
        else:
            count+=x[1]-y[0]
            y[0]=x[1]
    elif y[int((len(y)/2))]==x[1]:
        count+=0
        #print(int((len(y)/2)+1))
    elif x[1]>y[int((len(y)/2))]:
        for i in range(int(len(y)/2),len(y)):
            if y[i]>=x[1]:
                break
            else:
                count+=x[1]-y[i]
                y[i]=x[1]
    else:
        for i in range(int(len(y)/2),-1,-1):
            if y[i]<=x[1]:
                break
            else:
                count+=y[i]-x[1]
                y[i]=x[1]
    return count
print(med(n,m))