input()
repo = []
for i in range(3):
	repo.append(sum(map(int,input().split())))
print(repo[0]-repo[1],repo[1]-repo[2])
