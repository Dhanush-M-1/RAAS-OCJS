n = int(input())
s = str(input())
# m = len(s)
d = {}
if n==1:
    print(s)

else:
    for i in s:
        if i in d:
            d[i] = d[i]+1
        else:
            d[i]=1

    flag = 1
    for val in d.values():
        if val%n!=0:
            flag=0
            print("-1")
            break
    if flag:
        m=1
        ans =""
        for key in d:
            m=d[key]//n
            for i in range(0,m):
                ans+=key
        for i in range(0,n):
            print(ans,end="")

        

    
