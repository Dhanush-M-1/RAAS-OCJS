for _ in range(int(input())):
    n = int(input())
    l = [*map(int,input().split())]
    i = 0
    prev = -1
    while(i < n):
        if(l[i] - i >= 0):
            prev = l[i]
            l[i] = i
            i += 1
        else:
            break
    if(i == n):
        print("Yes")
        continue
    if(prev != -1 and i < n):
        l[i - 1] = prev
    #print("test = ",_+1," i = ",i)
    while(i < n):
        if(l[i - 1] > l[i]):
            i += 1
        elif(l[i - 1] <= l[i]):
            l[i] = l[i - 1] - 1
            if(l[i] < 0):
                break
            i += 1
        else:
            break
    if(i>=n):
        print("Yes")
    else:
        print('No')