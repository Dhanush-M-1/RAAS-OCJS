n=int(input())
ans=[0]*30
length=[0]*11
lol=[o for o in input().split()]
count=[0]*30
for i in range(n):
        length[len(lol[i])-1]+=1
#print(length)
for i in range(n):
        lol[i]=lol[i][::-1]
        for j in range(len(lol[i])):
                for k in range(j):
                        ans[2*k+(j-k)+1]+=2*(int(lol[i][j])*length[k])
                      #  print("kuch?",2*k+j-k,lol[i][j],int(lol[i][j])*length[k])
                for k in range(j,10):
                        ans[2*j]+= (int(lol[i][j])*length[k]) 
                        ans[2*j+1]+= (int(lol[i][j])*length[k]) 
#print(ans)
realans=["0"]*30
c=0

for i in range(30):
        realans[i]=str(int(ans[i]+c)%10)
        c=((ans[i]+c)//10)
        #print(realans[i],c,ans[i])
print((int("".join(realans[::-1])))%998244353)