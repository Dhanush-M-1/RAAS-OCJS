n,m=map(int,input().split())
total=[]
for i in range(n):
    data=input().split()
    for j in range(1,int(data[0])+1):
        if not data[j] in total:
            total.append(data[j])
print(["NO","YES"][len(total)==m])