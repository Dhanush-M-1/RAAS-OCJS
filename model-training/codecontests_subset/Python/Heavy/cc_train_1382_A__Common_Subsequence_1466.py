t = int(input())
for _ in range(t):
    (n, m) = map(int, input().split())
    ar = list(map(int, input().split()))
    br = list(map(int, input().split()))
    dict1 = {}
    dict2 = {}
    for i in range(len(ar)):
        if ar[i] in dict1:
            dict1[ar[i]] += 1
        else:
            dict1[ar[i]] = 1
    for i in range(len(br)):
        if br[i] in dict2:
            dict2[br[i]] += 1
        else:
            dict2[br[i]] = 1
    flag = False
    for i in dict1:
        if i in dict2:
            flag = True
            val = i
            break

    if flag == True:
        print("YES")
        print("1 {}".format(val))
    else:
        print("NO")
