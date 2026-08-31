def can_be_sharpened(array):
    upper = -1
    lower = -1
    size = len(array)
    if size == 1:
        return 'Yes'

    for i in range(size):
        if upper == -1 and i > array[i]:
           upper = i -1

    # print('---')
    for i in range(size - 1,-1,-1):
        val = (size - 1) - i
        # print(array[i],val)
        if lower == -1 and val > array[i]:
           lower = i + 1

    # print('lower,upper =',lower,upper)

    if lower == -1 or upper == -1:
        return "Yes"
    
    if (upper < lower):
        return "No"

    return 'Yes'

ans = []
n = int(input())
for i in range(n):
    _ = input()
    array = list(map(int,input().split()))
    ans.append(can_be_sharpened(array))
            
for i in range(n):
    print(ans[i])

# array = list(map(int,input().split()))
# print(can_be_sharpened(array))
