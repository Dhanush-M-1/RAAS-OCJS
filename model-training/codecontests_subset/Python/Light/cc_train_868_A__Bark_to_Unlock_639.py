s=input()
n=int(input())
slist=[]
true=False
for i in range(n):
    sinp=input()
    slist.append(sinp)
for i in range(n):

    for l in range(n):
        string=""
        string+=slist[i]
        string+=slist[l]
        if(string.find(s)!=-1):
            true=True
if(true):
    print("YES")
else:
    print("NO")