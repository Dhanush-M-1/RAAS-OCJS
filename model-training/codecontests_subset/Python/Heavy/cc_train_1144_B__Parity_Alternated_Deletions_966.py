n = int(input())
arr = list(map(int, input().split()))
cnt_even = 0; cnt_odd = 0; even = []; odd = []; flag = False
for i in range(n):
    if arr[i] % 2 == 0:
        cnt_even += 1
        even.append(arr[i])
    else:
        cnt_odd += 1
        odd.append(arr[i])
even.sort()
odd.sort()
if cnt_even == 0:
    cnt_odd -= 1
    flag = True
elif cnt_odd == 0:
    cnt_even -= 1
    flag = True
if (cnt_even == cnt_odd or cnt_even+1 == cnt_odd or cnt_even == cnt_odd+1) and (flag == False):
    print('0')
elif cnt_even > cnt_odd and flag == False:
    index = cnt_even - cnt_odd - 1
    print(sum(even[0:index]))
elif cnt_even < cnt_odd and flag == False:
    index = cnt_odd - cnt_even - 1
    print(sum(odd[0:index]))
elif cnt_even >= cnt_odd and flag == True:
    index = cnt_even
    print(sum(even[0:index]))
elif cnt_even <= cnt_odd and flag == True:
    index = cnt_odd
    print(sum(odd[0:index]))
