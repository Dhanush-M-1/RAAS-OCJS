import collections
import bisect

def k_equal(arr, take, n):
    arr.sort()
    presum = [0] * (n+1)
    postsum = [0] * (n+1)

    for i in range(n):
        presum[i+1] = presum[i] + arr[i]

    for i in range(n-1, -1, -1):
        postsum[i] = postsum[i+1] + arr[i]

    #print(arr)
    #print(presum)
    #print(postsum)
    
    left = right = 0
    ans = float('inf')
    while right < n:
        while right < n and arr[left] == arr[right]:
            right += 1

        if right - left >= take:
            return 0

        #print(left, right)

        pre_step = left * arr[left] - presum[left]
        post_step = postsum[right] - (n-right) * arr[left]
        need = take - right + left
        #print(f"use: {arr[left]}, left: {left}, right: {n-right}, need: {need}")
        #print(f"prestep: {left} * {arr[left]} - {presum[left]} = {pre_step}")
        #print(f"poststep: {postsum[right]} - {n-right} * {arr[left]} = {post_step}")
        #print(f"{pre_step} + {post_step} - {(left + n- right - need)} = {pre_step+post_step-(left + n- right - need)}")
        ans = min(ans, pre_step + post_step - (left + n- right - need))
        if left >= need:
            ans = min(ans, pre_step - (left - need))
            #print(f"left: {pre_step - (left - need)}")
        if (n-right) >= need:
            ans = min(ans, post_step - (n - right - need))
            #print(f"right: {post_step - (n - right - need)}")
        #print(f"ans: {ans}")
        left = right
    
    return ans


length, eq = [int(s) for s in input().split(" ")]  # read a list of integers, 2 in this case
arr = [int(s) for s in input().split(" ")]  # read a list of integers, 2 in this case
h = k_equal(arr, eq, length)
print(h)

#t = int(input())  # read a line with a single integer
#for i in range(1, t + 1):
#    length, eq = [int(s) for s in input().split(" ")]  # read a list of integers, 2 in this case
#    arr = [int(s) for s in input().split(" ")]  # read a list of integers, 2 in this case
#    h = k_equal(arr, eq, length)
#    print("Case #{}: {}".format(i, h))

