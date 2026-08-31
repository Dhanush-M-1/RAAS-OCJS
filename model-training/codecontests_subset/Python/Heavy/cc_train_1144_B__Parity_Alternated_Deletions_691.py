n = input()
a = list(map(int, input().split()))
even = []
odd = []
for num in a:
    #nums = str(bin(num))
    #c = nums.count('1')
    if num % 2 == 0:
        even.append(num)
    else:
        odd.append(num)
if abs(len(even)-len(odd)) <= 1:
    print(0)
else:
    if len(even) > len(odd):
        even.sort()
        odd.sort()
        e = len(even) - len(odd) - 1
        ans = 0
        for i in range(0, e):
            ans += even[i]
    else:
        even.sort()
        odd.sort()
        e = len(odd) - len(even) - 1
        ans = 0
        for i in range(0, e):
            ans += odd[i]
    print(ans)