n= int(input())
quer=[]
list=[2]
for i in range(n):
    flag,flag1,flag2=map(int,input().split())
    a=[flag,flag1,flag2]
    quer.append(a)
def check(quer,i):
    if(quer[i]>=1 and quer[i+1]>=2):
        return True
    return False
for i in range(n):
    a=0
    while(check(quer[i],0) or check(quer[i],1)):
        if quer[i][2]>=2:
            quer[i][2]-=2
            quer[i][1]-=1
            a+=3
        else:
            quer[i][1] -= 2
            quer[i][0] -= 1
            a+=3
    print(a)

