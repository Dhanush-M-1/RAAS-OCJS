def check():
    n = int(input())
    good = "YES"
    arr = []
    for i in range(n):
        p, c = map(int, input().split())
        if p == c or p > c:
            t1 = tuple([p,c])
            arr.append(t1)
        else:
            t1 = tuple([p,c])
            arr.append(t1)
            good = "NO"
        if i > 0 and arr[i][0] < arr[i-1][0]:
            good = "NO"
        else:
            diff = arr[i][0] - arr[i-1][0]
        if i > 0 and arr[i][1] < arr[i-1][1]:
            good = "NO"
        if i > 0 and arr[i][1] > diff + arr[i-1][1]:
            good = "NO"
    return good
for _ in range(int(input())):           
    print(check())


            
        
