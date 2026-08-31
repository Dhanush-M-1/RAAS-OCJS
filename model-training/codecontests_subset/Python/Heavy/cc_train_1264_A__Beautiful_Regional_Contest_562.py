def mi():
    return map(int, input().split())

'''
5
12
4
4
4 3 2 1
1
1000000
20
20 19 18 17 16 15 14 13 12 11 10 9 8 7 6 5 4 3 2 1
3
64 64 63 58 58 58 58 58 37 37 37 37 34 34 28 28 28 28 28 28 24 24 19 17 17 17 17 16 16 16 16 11
'''
for _ in range(int(input())):
    n = int(input())
    a = list(mi())
    
    m = n//2-1
    while m>=0 and m+1<n and a[m]==a[m+1]:
        m-=1
    m+=1
    m = min(m,n//2)
    a=a[:m]
    if m<=2 or max(a)-min(a)<=1:
        print (0,0,0)
        continue
    g,s,b=1,0,0
    for i in range(1, m):
        if a[i]==a[i-1] :
            if s==0:
                g+=1
            elif b==0 or g>=s:
                s+=1
            else:
                b+=1
        else:
            if s==0 or g>=s:
                s+=1
            else:
                b+=1
    if g>=b or g>=s or g==0 or b==0 or s==0:
        print (0,0,0)
    else:
        print (g,s,b)
    