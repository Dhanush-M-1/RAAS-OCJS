n,k = map(int,input().split())
data = []
a_num = 0
b_num = 0
a_array = []
b_array = []
ab_array = []
time_sum = 0
for i in range(n):
    time,a,b = map(int,input().split())
    if a and b:
        a_num+=1
        b_num+=1
        ab_array.append(time)
    elif a:
        a_num+=1
        a_array.append(time)
    elif b :
        b_num+=1
        b_array.append(time)

if a_num<k or b_num<k:
    print(-1)
else:
    a_array.sort()
    b_array.sort()
    while a_array and b_array:
        ab_array.append(a_array.pop(0)+b_array.pop(0))
    ab_array.sort()
    for i in range(k):
        time_sum+=ab_array[i]
    print(time_sum)