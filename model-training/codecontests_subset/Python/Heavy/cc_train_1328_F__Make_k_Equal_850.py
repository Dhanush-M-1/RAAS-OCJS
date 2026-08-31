def fuck(num,i):
    fuck = 0
    while num >= i:
        if num == i:
            return fuck
        num //= 2
        fuck += 1
    return False


lenK = list(map(int,input().split()))
lens = lenK[0]
K = lenK[1]
nums = list(map(int,input().split()))

nums.sort()
lists = [[nums[0],1]]
up = nums[0]
for i in nums[1:]:
    if i == up:
        lists[-1][1] += 1
    else:
        up = i
        lists.append([i,1])
mis = -1
# print(lists)
for i in range(len(lists)):
    thisN = lists[i][0]
    thisP = 0
    tk = K - lists[i][1]
    if tk <= 0:
        mis = 0
        break
    ji = 0
    while True:
        for j in range(i + 1,len(lists)):
            dong =  fuck(lists[j][0],thisN)
            if dong != False:
                thisP += min(tk,lists[j][1])*dong
                tk -= min(tk,lists[j][1])
            # if dong != False:
            #     print(str(lists[j][0])+"除以"+str(dong)+"次="+str(thisN),lists[i][0],thisP)
            if tk == 0:

                # print(mis, thisP, thisN, i,j, lists[j])
                if mis == -1 or mis > thisP:
                    mis = thisP
                    # print("fuck")
                break
        if thisN == 0:
            break
        thisN //= 2
        ji += 1
        thisP = ji*lists[i][1]
        # print(thisP)
        tk = K - lists[i][1]

print(int(mis))