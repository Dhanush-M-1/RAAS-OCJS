data = input().split('+')
def merge_sort(data):
	middle = int(len(data)/2)
	if len(data) > 1:
		dataLeft = merge_sort(data[0:middle])
		dataRight = merge_sort(data[middle:])
		left = 0
		right = 0
		tempArr = []
		while left < middle or right < len(dataRight):
			if left == middle:
				for i in range(right,len(dataRight)):
					tempArr.append(dataRight[i])
					right+=1
				break
			if right == len(dataRight):
				for i in range(left,middle):
					tempArr.append(dataLeft[i])
					left+=1
				break
			if dataLeft[left] <= dataRight[right]:
				tempArr.append(dataLeft[left])
				left+=1
			else:
				tempArr.append(dataRight[right])
				right+=1
		return tempArr
	else: 
		return data



data = merge_sort(data)

res=data[0]
for i in range(len(data)-1):
	res+='+'
	res+=data[i+1]
print(res)