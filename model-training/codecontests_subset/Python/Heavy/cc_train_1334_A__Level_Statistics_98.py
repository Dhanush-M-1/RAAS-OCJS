no_test=int(input(""))
result=[]
if no_test>0:
    for i in range(no_test):
        no_look=int(input(""))
        look=list()
        for j in range(no_look):
            x,y=input("").split()
            p,c= int(x),int(y)
            look.append((p,c))
        count=1
        if not (look[0][0]>=look[0][1] and look[0][1]>=0):
            result.append("NO")
            continue
        for k in range(len(look)-1):
            if (look[k+1][1]-look[k][1])<=(look[k+1][0]-look[k][0]) and (look[k+1][1]-look[k][1])>=0:
                count+=1
        if count==len(look):
            result.append("YES")
        else:
            result.append("NO")
for item in result:
    print(item)