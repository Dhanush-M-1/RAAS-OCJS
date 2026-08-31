if __name__ == '__main__':
    n = int(input())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    c = list(map(int,input().split()))
    a.sort()
    b.sort()
    c.sort()
    ans = []
    for i,j in zip(a,b):
        if i!=j:
            ans.append(i)
            break
    else:
        ans.append(a[-1])
    for i,j in zip(b,c):
        if i!=j:
            ans.append(i)
            break
    else:
        ans.append(b[-1])
    for i in ans:
        print(i)