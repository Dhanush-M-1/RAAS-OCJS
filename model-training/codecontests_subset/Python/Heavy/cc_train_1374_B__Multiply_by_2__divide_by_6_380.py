import sys
t = int(input())
nums = []
for x in range(t):
    nums.append(int(input()))

for n in nums:
    if n == 1:
        print(0)
        continue
    if n%3 !=0:
        print(-1)
        continue
    else:
        b = n
        count_3= 0
        while b%3 == 0:
            count_3 +=1
            b/=3
        b = n
        count_2 = 0
        while b%2 == 0:
            count_2 +=1
            b/=2
        if count_3 < count_2:
            print(-1)
            continue
        elif (2**count_2)*(3**count_3) != n:
            print(-1)
            continue
        print(2*count_3-count_2)
        
