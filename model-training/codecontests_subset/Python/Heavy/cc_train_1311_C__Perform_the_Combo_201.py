for _ in range(int(input())):
    n,m = list(map(int,input().split()))
    combo = input()
    arr = list(map(int,input().split()))
    x = 'abcdefghijklmnopqrstuvwxyz'
    mat = []
    temp = [0 for i in range(26)]
    temp[ord(combo[0])-97] = 1
    mat.append(temp)
    for i in range(1,n):
        temp = mat[-1][::]
        temp[ord(combo[i])-97]+=1
        mat.append(temp)
    d = {}
    cnt = 0
    for i in x:
        d[cnt] = 0
        cnt+=1
    for i in arr:
        ind = i-1
        temp = mat[ind]
        # print(temp)
        cnt = 0
        for j in temp:
            d[cnt]+=j
            cnt+=1
    for i in combo:
        d[ord(i)-97]+=1
    x = ''
    for i in range(26):
        x+=str(d[i])+' '
    print(x)