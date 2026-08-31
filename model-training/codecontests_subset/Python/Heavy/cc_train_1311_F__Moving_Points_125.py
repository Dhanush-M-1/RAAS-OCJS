import operator 
import collections 
from sys import stdin


N = int(input())
pos = list(map(int, stdin.readline().split()))
speed = list(map(int, stdin.readline().split()))

A = []
for i in range(N):
	A.append((pos[i], speed[i]))	

# organized A by position from least to greatest
# We want to count, at each x_i, the number of j such that x_j < x_i and 
# v_j <= x_i
dist = {}
for i in pos:
	dist[i] = 0
A.sort(key = operator.itemgetter(0))
# Now we do merge sort on the speeds but with comparing...
# if right is chosen over left, then we record [right] += right.pos - left.pos


count = [0]
def merge_compare(p, r):
	if p < r:
		q = (r + p)//2
		merge_compare(p, q)
		merge_compare(q + 1, r)
		merge(p, q, r)



# A is POSITION, SPEED
# merging two sorted subsets A[p:q + 1], A[q + 1:r + 1] into a sorted
# subset A[p:r + 1]
def merge(p, q, r):
	n_1 = q - p + 1
	n_2 = r - q
	temp = []
	L = A[p:q + 1]
	R = A[q + 1:r + 1]
	i = 0
	j = 0

	# calculatin the sum of all the positions in R
	sum_pos_right = 0
	for e, f in R:
		sum_pos_right += e


	while i < n_1 and j < n_2:
		if L[i][1] <= R[j][1]:
			temp.append(L[i])
			count[0] += sum_pos_right - L[i][0]*(n_2 - j)
			i += 1
		else:
			temp.append(R[j])
			sum_pos_right -= R[j][0]
			j += 1
	if i == n_1:
		temp += R[j:]
	else:
		temp += L[i:]
	A[p:r + 1] = temp


merge_compare(0, N - 1)

print (count[0])


