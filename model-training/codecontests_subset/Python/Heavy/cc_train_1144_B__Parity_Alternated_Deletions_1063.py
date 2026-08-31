n = int(input())
l =[int(x) for x in input().split()]
l.sort()
l.reverse()
odd_list = []
even_list = []
for i in l:
	if i%2 == 0:
		even_list.append(i)
	else:
		odd_list.append(i)
len_oddlist = len(odd_list)
len_evenlist = len(even_list)
sum = 0
if len_oddlist - len_evenlist >= 1:
	while len_oddlist -len_evenlist > 1:
		sum += odd_list[len_oddlist-1]
		len_oddlist-=1
if len_evenlist - len_oddlist >= 1 :
	while len_evenlist - len_oddlist > 1:
		sum += even_list[len_evenlist-1]
		len_evenlist-=1
print(sum)