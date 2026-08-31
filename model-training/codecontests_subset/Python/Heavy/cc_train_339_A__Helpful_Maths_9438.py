s = input("")
nums = list(map(int, s.split("+")))

def sort(nums):
    if len(nums) in [0,1]:
        return nums

    a = sort(nums[:len(nums)//2])       # sort half 1
    b = sort(nums[len(nums)//2:])       # sort half 2

    result = []
    while len(a) and len(b):
        if a[0] > b[0]:
            result.append(b[0])
            b.pop(0)
        else:
            result.append(a[0])
            a.pop(0)

    if len(a):
        for item in a:
            result.append(item)
    if len(b):
        for item in b:
            result.append(item)
    return result

c = sort(nums)

print("+".join(str(item) for item in c))
