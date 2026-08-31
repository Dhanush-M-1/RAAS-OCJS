n = int(input())
trees = []
for t in range(n):
	trees.append(list(map(int, input().split())))

if n < 2:
    print(n)
else:
    min = trees[0][0]
    cut = 2
    for i in range(1, n-1):
    	t = trees[i]
    	x = t[0]
    	h = t[1]
    	max = trees[i+1][0]		
    	cut_left = (x - h, x)
    	cut_right = (x, x + h)
    	if cut_left[0] > min:
    		cut += 1
    		min = cut_left[1]
    	elif cut_right[1] < max:
    		cut+= 1
    		min = cut_right[1]
    	else:
    		min = x
    print(cut)