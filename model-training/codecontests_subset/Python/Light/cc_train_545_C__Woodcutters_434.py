n=int(input())
mx=[]
for i in range(n):
    mx.append([int(x) for x in input().split()])
t=2  #最左边和最右边的树不妨碍
if n==1:
    print(1)
else:
    for i in range(1,n-1):
        if mx[i][0]-mx[i][1]>mx[i-1][0]:
            t+=1        #x向左倒不影响下一棵树的判断
        elif mx[i][0]+mx[i][1]<mx[i+1][0]:
            t+=1
            mx[i][0]+=mx[i][1] #向右倒影响
    print(t)            
            