t=int(input())
st=input()
ct=0
for i in range(t):
	if int(st[i])==8:
		ct+=1
t-=ct
ans=0
while(1):
	if ct==0:
		break
	if ct*10<=t:
		ans=ct
		break
	else:
		ct-=1
		t+=1
print(ans)
