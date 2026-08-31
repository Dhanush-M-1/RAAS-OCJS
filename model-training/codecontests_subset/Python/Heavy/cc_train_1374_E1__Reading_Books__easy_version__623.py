
n, k = [int(i) for i in input().split()]
arr = []
for i in range(n):
    arr.append([int(i) for i in input().split()])

one_one = []
zero_one = []
one_zero = []

for i in arr:
    if i[2] == i[1] == 1:
        one_one.append(i[0])
    elif i[1] == 1:
        one_zero.append(i[0])
    elif i[2] == 1:
        zero_one.append(i[0])

one_one.append(10**20)
one_zero.append(10**20)
zero_one.append(10**20)

one_one.sort()
zero_one.sort()
one_zero.sort()


ptr1 = ptr2 = ptr3 = 0

n1 = 0
ans = 0
while n1 < k:
    if one_one[ptr1] < one_zero[ptr2] + zero_one[ptr3]:        
        ans += one_one[ptr1]
        ptr1 += 1
        n1 += 1
    else:
        ans += one_zero[ptr2] + zero_one[ptr3]
        ptr2 += 1
        ptr3 += 1
        n1 += 1
    
    if ans >= 10**20:
        ans = -1
        break
    


print(ans)
    
