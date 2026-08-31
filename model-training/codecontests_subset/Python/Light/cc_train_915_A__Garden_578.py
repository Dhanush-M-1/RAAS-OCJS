s=list(map(int,input().split()))
list_of_lengths=list(map(int,input().split()))
a=[]
for j in range(len(list_of_lengths)):
	if (s[1]%list_of_lengths[j]==0):
		a.append(int(s[1]//list_of_lengths[j]))
print(min(a))

