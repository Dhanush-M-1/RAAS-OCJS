x = int(input())
a = [int(input()) for i in range(x)]
# print(a)
# print(len(a))
k = 0
t = 0
t1 = 0
if a[0] == 3:
	print("NO")
	k = 1
elif x == 1:
	if a[0] == 3:
		print("NO")
		k = 1
	else:
		print("YES")
		k = 1

elif a[0] == 1:
		t = 1
		t1 = 2
elif a[0] == 2:
	t = 2
	t1 = 1
for i in range(x-1):
	
	# print(i)
	# print([t,t1])
	if a[i+1] == t1:
		# print(a[i])
		# print(i)
		# print([t,t1])
		print("NO")
		k = 1
		break
	elif a[i+1] == t and t1 == 1 and t == 2:
		t = 2
		t1 = 3
	elif a[i+1] == t and t1 == 1 and t == 3:
		t = 3
		t1 = 2
	elif a[i+1] == t and t1 == 2 and t == 1:
		t = 1
		t1 = 3
	elif a[i+1] == t and t1 == 2 and t == 3:
		t = 3
		t1 = 1
	elif a[i+1] == t and t1 == 3 and t == 1:
		t = 1
		t1 = 2
	elif a[i+1] == t and t1 == 3 and t == 2:
		t = 2
		t1 = 1
	else:
		t1 = t
		t = a[i+1]
		# print(t,t1)
if k == 0:
	print("YES")