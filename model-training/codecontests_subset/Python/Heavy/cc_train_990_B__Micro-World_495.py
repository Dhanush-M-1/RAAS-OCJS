n, k = tuple(map(int, input().split(' ')))
a = list(map(int, input().split(' ')))

a = sorted(a, reverse=True)

index = 0
count = 0

def sec(aj, ai):
    return aj < ai and aj >= ai-k

def bSearch(iai, a):
    if iai == len(a) - 1:
        return None
    if not sec(a[iai+1], a[iai]):
        return False

    high = len(a)
    low = iai

    while low < high-1:
        mid = (high+low)//2
        if sec(a[mid], a[iai]):
            low = mid
        else:
            high = mid

    return low

while index < len(a)-1:
    mid = bSearch(index, a)
    if mid == False:
        index += 1
        count += 1

    else:
        index += (mid-index)

print(count+1)

