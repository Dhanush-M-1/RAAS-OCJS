# WHERE: https://codeforces.com/problemset/page/8?order=BY_RATING_ASC

# Taxi
# https://codeforces.com/problemset/problem/158/B
# Input
# The first line contains integer n (1 ≤ n ≤ 105) — the number of groups of schoolchildren. The second line contains a sequence of integers s1, s2, ..., sn (1 ≤ si ≤ 4). The integers are separated by a space, si is the number of children in the i-th group.
# Output
# Print the single number — the minimum number of taxis necessary to drive all children to Polycarpus.
# ignoreInput = input()
# groups = list(map(int, input().split()))
# i = 0
# j = len(groups) - 1  # last position of the array
# counter = 0

# counters = [0, 0, 0, 0]

# for group in groups:
#     counters[(group-1)] += 1

# fours = counters[3]
# threes = counters[2]
# ones = 0
# if counters[0] > threes:
#     ones = counters[0] - threes
# twos = (counters[1]//2) + (((counters[1] % 2)*2+ones)//4)
# # left = 0
# if (((counters[1] % 2)*2+ones) % 4) != 0:
#     twos += 1

# print(fours+threes+twos)
# ---------------------------------------------------------------------------------------------------------------------

# Fancy Fence
# https://codeforces.com/problemset/problem/270/A
# Input
# The first line of input contains an integer t (0 < t < 180) — the number of tests. Each of the following t lines contains a single integer a (0 < a < 180) — the angle the robot can make corners at measured in degrees.
# Output
# For each test, output on a single line "YES" (without quotes), if the robot can build a fence Emuskald wants, and "NO" (without quotes), if it is impossible.

# times = int(input())
# answers = []
# for time in range(times):
#     a = int(input())
#     if 360 % (180 - a) == 0:
#         answers.append("YES")
#     else:
#         answers.append("NO")
# for answer in answers:
#     print(answer)
# ---------------------------------------------------------------------------------------------------------------------

# Interesting drink
# https://codeforces.com/problemset/problem/706/B
# Input
# The first line of the input contains a single integer n (1 ≤ n ≤ 100 000) — the number of shops in the city that sell Vasiliy's favourite drink.
# The second line contains n integers xi (1 ≤ xi ≤ 100 000) — prices of the bottles of the drink in the i-th shop.
# The third line contains a single integer q (1 ≤ q ≤ 100 000) — the number of days Vasiliy plans to buy the drink.
# Then follow q lines each containing one integer mi (1 ≤ mi ≤ 109) — the number of coins Vasiliy can spent on the i-th day.
# Output
# Print q integers. The i-th of them should be equal to the number of shops where Vasiliy will be able to buy a bottle of the drink on the i-th day.

# nShops = int(input())
# shopPrices = list(map(int, input().split()))
# shopPrices.sort()
# times = int(input())
# answers = []


# def binarySearch(array, target, carry):
#     index = len(array)
#     if len(array) == 0:
#         return carry
#     if index == 1:
#         if target < array[0]:
#             return carry
#         else:
#             return carry + 1
#     # position in the middle
#     index = index//2
#     if target < array[index]:
#         # return the left
#         newPrices = array[0:index]
#         return binarySearch(newPrices, target, carry)
#     else:
#         # return the right
#         carry += (index)
#         newPrices = array[index:]
#         return binarySearch(newPrices, target, carry)


# def iterativeBinary(array, target):
#     low = 0
#     high = len(array) - 1
#     while (low <= high):
#         mid = low + ((high-low)//2)
#         if array[mid] > target:
#             high = mid - 1
#         else:
#             low = mid + 1

#     return low


# for time in range(times):
#     money = int(input())
#     # looks like the way i implemented the binary search isnt logN :(
#     # buys = binarySearch(shopPrices, money, 0)
#     buys = iterativeBinary(shopPrices, money)
#     answers.append(buys)
# for answer in answers:
#     print(answer)
# ---------------------------------------------------------------------------------------------------------------------

# A and B and Compilation Errors
# https://codeforces.com/problemset/problem/519/B
# Output
# Print two numbers on a single line: the numbers of the compilation errors that disappeared after B made the first and the second correction, respectively.

compilationTimes = int(input())
errors1 = list(map(int, input().split()))
errors2 = list(map(int, input().split()))
errors3 = list(map(int, input().split()))

errors1.sort()
errors2.sort()
errors3.sort()

n = -1
isNFound = False
m = -1
isMFound = False
for time in range(compilationTimes):
    if isNFound and isMFound:
        break
    if not isNFound:
        if time < len(errors2):
            if errors1[time] != errors2[time]:
                n = errors1[time]
                isNFound = True
        else:
            n = errors1[time]
            isNFound = True
    if not isMFound:
        if time < len(errors3):
            if errors2[time] != errors3[time]:
                m = errors2[time]
                isMFound = True
        else:
            m = errors2[time]
            isMFound = True


print(n)
print(m)
# ---------------------------------------------------------------------------------------------------------------------
