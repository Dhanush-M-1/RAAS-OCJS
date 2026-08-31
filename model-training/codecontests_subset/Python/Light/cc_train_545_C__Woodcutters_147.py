n=int(input())
l=[[*map(int,input().split())]for _ in' '*n]
a=0;t=l[0][0]
for i in range(1,n-1):
    if l[i][0]-t-l[i][1]>0:a+=1;t=l[i][0];continue
    if l[i+1][0]-l[i][0]-l[i][1]>0:a+=1;t=l[i][0]+l[i][1]
    else:t=l[i][0]
print([1,a+2][n>1])