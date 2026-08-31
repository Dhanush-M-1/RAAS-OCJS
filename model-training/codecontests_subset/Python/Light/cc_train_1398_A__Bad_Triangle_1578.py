def badt(n,a):

    if a[0]+a[n//2]<=a[n-1]:
        return [1,n//2+1,n]
    else:

        for i in range(1,n//2):
            sum = a[0]+a[i]
            if sum<=a[n-1]:
                return [1,i+1,n]
        return [-1]


if __name__ == '__main__':
    n = int(input())
    res = []
   
    for i in range(n):
        p = int(input())
        a = list(map(int, input().split()))
        res.append(badt(p,a))

    for j in res:
        tmp = len(j)
        tmp3 = ((str(j).strip("[]")).replace(",",""))
        print(tmp3)