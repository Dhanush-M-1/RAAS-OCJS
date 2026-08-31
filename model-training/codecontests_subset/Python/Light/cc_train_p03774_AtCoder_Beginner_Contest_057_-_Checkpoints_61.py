n,m=map(int,input().split())
n_list=[list(map(int,input().split())) for i in range(n)]
m_list=[list(map(int,input().split())) for i in range(m)]
for i in range(n):
	list=[]
	for j in range(m):
		x=abs(n_list[i][0]-m_list[j][0])
		y=abs(n_list[i][1]-m_list[j][1])
		list.append(x+y)
	print(list.index(min(list))+1)