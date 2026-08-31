
def process():
    n=int(input())
    li=[]
    for i in range(n):
        li.append(list(input()))

    ans=[]
    if(li[0][1]!=li[1][0] and li[n-1][n-2]!=li[n-2][n-1]):
        if(li[0][1]!='0'):
            ans.append((0,1))
        if(li[1][0]!='0'):
            ans.append((1,0))
        if(li[n-1][n-2]!='1'):
            ans.append((n-1,n-2))
        if (li[n - 2][n - 1] != '1'):
            ans.append((n - 2, n - 1))
    elif(li[0][1]==li[1][0] and li[n-1][n-2]==li[n-2][n-1]):
        if (li[0][1] == li[n-1][n-2]):
            ans.append((0, 1))
        if (li[1][0] == li[n-1][n-2]):
            ans.append((1, 0))
    elif(li[0][1]==li[1][0]):
        if (li[n - 1][n - 2] == li[1][0]):
            ans.append((n - 1, n - 2))
        if (li[n - 2][n - 1] == li[1][0]):
            ans.append((n - 2, n - 1))
    elif(li[n-1][n-2]==li[n-2][n-1]):
        if (li[0][1] == li[n-1][n-2]):
            ans.append((0, 1))
        if (li[1][0] == li[n-1][n-2]):
            ans.append((1, 0))
    print(len(ans))
    for i in ans:
        print(i[0]+1,i[1]+1)









tests=int(input())
for i in range(tests):
    process()