n, k = map(int, input().split())
arr = []
for i in sorted(map(int, input().split())):
	if not arr or arr[-1][0] != i:
		arr.append([i, 1])
	else:
		arr[-1][1] += 1

costSum = []
countSum = []
for i, count in arr:
	if costSum:
		costSum.append(costSum[-1] + count * i)
		countSum.append(countSum[-1] + count)
	else:
		costSum.append(count * i)
		countSum.append(count)

# print(arr)
# print(countSum)
# print(costSum)

if len(arr) > 1 and k > arr[0][1] and k > arr[-1][1]:
	res = min(costSum[-1] - costSum[0] - (countSum[-1] - countSum[0]) * arr[0][0] - countSum[-1] + k, arr[-1][0] * countSum[-2] - costSum[-2] - countSum[-1] + k)
	# print(costSum[-1] - costSum[0] - (countSum[-1] - countSum[0]) * arr[0][0] - countSum[-1] + k, arr[-1][0] * countSum[-2] - costSum[-2] - countSum[-1] + k)
else:
	res = 0

for i in range(1, len(arr) - 1):
	cost = 0
	fromLeft = arr[i][0] * countSum[i] - costSum[i]
	fromRight = costSum[-1] - costSum[i] - arr[i][0] * (countSum[-1] - countSum[i])
	# print(i, fromLeft, fromRight)
	if countSum[i] < k:
		cost = fromLeft + fromRight + k - countSum[-1]
	elif arr[i][1] < k:
		cost = fromLeft + k - countSum[i]
	# print(cost)
	if countSum[-1] - countSum[i-1] >= k and arr[i][1] < k:
		cost = min(cost, fromRight + k - countSum[-1] + countSum[i-1])
	if res > cost:
		res = cost

print(res)
