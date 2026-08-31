import sys
def i():
    return sys.stdin.readline()[:-1]

def count(l,i):
    return sum(x==i for x in i)
l,desiredSame = map(int,i().split())
nums = list(map(int,i().split()))

pos = set()
pos.add(0)
for item in nums:
    while item > 0:
        pos.add(item)
        item >>=1

currMin = 9000
for x in pos:
    distance = []
    for item in nums:
        shift = 0
        while item > x:
            shift += 1
            item >>= 1
        if item == x:
            distance.append(shift)
    if len(distance) >= desiredSame:
        currMin = min(currMin, sum(sorted(distance)[:desiredSame]))
print(currMin)