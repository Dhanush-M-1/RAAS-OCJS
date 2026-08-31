n,m=input("").split(" ")
n,m=int(n),int(m)
t=[]
for i in  range(n):
                t.append(list(map(int,input("").split(" "))))
h=[]
for j in t:
                for k in range(1,j[0]+1):
                                h.append(j[k])
count=0
for p in range(1,m+1):
                for o in h:
                                if p==o:
                                                count+=1
                                                break
if count==m:
                print("YES")
else:
                print("NO")

