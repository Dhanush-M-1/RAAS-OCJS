for _ in range(int(input())):
    s1,s2=input().split()
    arr=list(s1)
    ans=sorted(arr)
    dic={}
    for i in range(len(s1)):
        try:
            dic[arr[i]].append(i)
        except:
            dic[arr[i]]=[i]
    # print(dic)
    if s1<s2:
        print(s1)
        continue
    for i in range(len(s1)):
        if arr[i]!=ans[i]:
    #         print(arr[i],ans[i])
            z=dic[ans[i]][-1]
            temp=arr[i]
            arr[i]=ans[i]
    #         print(z)
            arr[z]=temp
    #         print(arr[i],ans[i])
            break
    
    # print(''.join(arr))
    if ''.join(arr)<s2:
        print(''.join(arr))
    else:
        print('---')