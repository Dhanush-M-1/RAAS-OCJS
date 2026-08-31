for _ in range(int(input())):
    num = int(input())
    queue = []
    for k in range(num):
        a,b = map(int,input().split())
        queue.append([a,b])
    current = queue.pop(0)
    ans = "YES"
    if current[1] > current[0]:
        ans = "NO"
    while(len(queue)!=0):
        temp = queue.pop(0)
        if temp[1]>temp[0]:
            ans = "NO"
            break
        else:
            pdiff = temp[0] - current[0]
            cdiff = temp[1] - current[1]
            if cdiff<= pdiff and cdiff>=0:
                current = temp
            else:
                ans = "NO"
                break
    print(ans)