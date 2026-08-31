a = int(input())
nums = map(int, input().split(' '))

# a = sorted(map(int, input().split(' ')), reverse=True)
# m = int(input())
# q = map(int, input().split(' '))

def calc(a, nums):
    odds = list()
    evens = list()
    for i in nums:
        if i % 2:
            odds.append(i)
        else:
            evens.append(i)
    
    if abs(len(odds) - len(evens)) <= 1:
        return 0
    
    if len(odds) > len(evens):
        return sum(sorted(odds)[:-len(evens) - 1])
    else:
        return sum(sorted(evens)[:-len(odds) - 1])
    
print(calc(a, nums))