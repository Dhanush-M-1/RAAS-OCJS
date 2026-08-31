
t = int(input())
for i in range(t):
    a = []
    b = []
    n,m = map(int,input().split())
    a = list(map(int,input().split()))
    b = list(map(int,input().split()))
    arr = []
    if n >= m:
        for i in a:
            if i in b:
                if i not in arr:
                    arr.append(i)
                    if len(arr) >= 1:
                        break
    else:
        for i in b:
            if i in a:
                if i not in arr:
                    arr.append(i)
                    if len(arr) >= 1:
                        break
    if len(arr) == 0:
        print('NO')
    else:
        print('YES')
        ans = map(str,arr)
        print(str(len(arr)) + ' ' + ' '.join(ans))