import heapq

length, target = [int(x) for x in input().split()]
nums = [int(x) for x in input().split()]
nums = sorted(nums)

lower = [x*-1 for x in reversed(nums[:int(length/2)])]
median = nums[int(length/2)]
upper = nums[int(length/2) + 1:]

required = 0
while median != target:
    required += abs(target - median)
    median = target

    if upper and median > upper[0]:
        heapq.heappush(upper, median)
        median = heapq.heappop(upper)
    else:
        heapq.heappush(lower, median*-1)
        median = heapq.heappop(lower)*-1

print(required)
 	 				   	  			  		   	   		 	