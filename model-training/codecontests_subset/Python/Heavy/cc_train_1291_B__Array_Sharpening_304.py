t=int(input())
for i in range(t):
    n=int(input())
    lst = list(map(int, input().strip().split(' ')))
    #d,g,b = map(int, input().strip().split(' '))
    f=-1
    for j in range(n):
        if lst[j]<j:
            f=j
            break
    if f==-1:
        print('yes')
    else:
        if j<n and lst[j]==lst[j-1] and lst[j]==n-j-1:
            print('no')
        else:
            a=[]
            a[:]=lst[j:]
            f=-1
            a.reverse()

            for j in range(len(a)):
                if a[j]<j:
                    f=0
                    print('no')
                    break

            if f==-1:
                print('yes')
        
        
        
        

    