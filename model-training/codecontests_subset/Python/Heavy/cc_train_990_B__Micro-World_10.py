stfn, stfk = input().split()
n,K = int(stfn), int(stfk)

array = [int(s) for s in input().split()]
array = sorted(array)

hmap = dict()

ar = [array[0]]

for j in array:
	if j != ar[-1]:
		ar.append(j)

	if j in hmap:
		hmap[j] += 1
	else:
		hmap[j] = 1

arr = []
i = 0

while i < len(ar) - 1:
	if not (ar[i+1] > ar[i] and ar[i+1] <= ar[i]+K):
		arr.append(ar[i])
	
	i += 1

arr.append(ar[-1])

additLength = 0
for j in arr:
	if j in hmap:
		additLength += (hmap[j]-1)

print(len(arr) + additLength)


