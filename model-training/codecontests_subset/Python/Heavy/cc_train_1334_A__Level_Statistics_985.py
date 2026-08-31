t=int(input())
for k in range(t):
    v1=0
    v2=0
    flag=0
    n=input()
    n=int(n)
    for i in range(n):
        p,c = map(int, input().split())
        if p<c or p<v1 or c<v2 or (c-v2)>(p-v1):
            flag=1
        '''if p>=c and p>=v1 and c>=v2:
            pass
        else:
            flag = 1
            #if flag==0:
                #ls.append('NO')
              #print("NO")'''
        v1=max(p,v1)
        v2=max(c,v2)
    if flag==0:
        print("YES")
    else:
        print("NO")
        #print("YES")

