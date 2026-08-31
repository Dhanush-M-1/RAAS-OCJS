n, m = input().split(' ')
n = int(n)
m = int(m)

bulbs_list=[]
for i in range(n):
	temp = input().split(' ')
	bulbs_list = bulbs_list + temp[1:]

bulbs_set = set(bulbs_list)

if len(bulbs_set)==m:
	print("YES")
else:
	print("NO")