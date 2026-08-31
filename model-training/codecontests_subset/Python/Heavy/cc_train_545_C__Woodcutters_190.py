# Woodcutters
n = int(input())
dist = []
height = []
for i in range(n):
	d, h = map(int, input().split())
	dist.append(d)
	height.append(h)


# Decision questions:
# Need information about previous tree and next tree, that is why starting from tree 1.
# Assume that I can always cut zero's tree to the left therefore cut count starts from one. 
# Can I cut it left, if can I do it as there is no harm in doing it and increase cut count by one.
# If I can't cut it left, next question is can I cut it right?
# If can cut it right, I do it and update the coordinate of the tree.
# If I can't cut it right, I don't do it and move to the next tree. 

# Initialize cut count as two as it will account for the first tree and last tree that we can always cut
cut_count = 2
for i in range(1, n - 1):
	# Can I cut the tree to the left?
	if dist[i] - height[i] > dist[i-1]:
		# Answer is yes, so cut it and increase count by one
		cut_count += 1
	# Can I cut the tree to the right?
	else: 
		if dist[i] + height[i] < dist[i + 1]:
			# Answer is yes, so cut it, increase count by one and update the coordinate of the tree
			cut_count += 1
			dist[i] = dist[i] + height[i]
	# Move the next tree if it is not possible to cut left or right

# Special case if only one tree it is only possible to cut one tree:
if n == 1:
	print(1)
else:
	print(cut_count)