# possibilities = []
# for a in range(1, 10):
#     for b in range(1, 10):
#         if set([a, 15-a-b, b, 5+b-a, 5, 5+a-b, 10-b, a+b-5, 10-a]) == set(range(1, 10)):
#             possibilities.append([a, 15-a-b, b,
#                                   5+b-a, 5, 5+a-b,
#                                   10-b, a+b-5, 10-a])

# matrix = []
# for _ in range(3):
#     for each in list(map(int, input().split())):
#         matrix.append(each)

# minCost = 100
# for possibility in possibilities:
#     cost = 0
#     for i in range(9):
#         cost += abs(matrix[i] - possibility[i])
#     if cost < minCost:
#         minCost = cost
# print(minCost)



def solve(s):
    for i in range(1,len(s)):
        be_ones = s[:i].count('1')
        be_zeroes = s[:i].count('0')
        af_ones = s[i:].count('1')
        af_zeroes = s[i:].count('0')
        if be_ones != af_ones or be_zeroes != af_zeroes:
            print(2)
            print(s[:i],s[i:])
            break
 
n=int(input())
s=str(input())
ones = s.count('1')
zeroes = s.count('0')
if ones == zeroes:
    if len(s) == 1:
        print(1)
        print(s)
    else:
        solve(s)
else:
    print(1)
    print(s)