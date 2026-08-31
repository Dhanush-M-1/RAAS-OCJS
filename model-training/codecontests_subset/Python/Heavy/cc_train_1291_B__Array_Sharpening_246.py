from sys import stdin
for _ in range(int(input())):
    n=int(input())
    l=list(map(int,stdin.readline().split()))
    ind = -1
    for i in range(n):
        if l[i]>=i:
            pass
        else:
            ind = i
            break
    if ind == -1:
        print("Yes")
    else:
        f=0
        if ind == n-1:
            if l[ind]==l[ind-1] and l[-1]==0:
                print("No")
                f=1
            else:
                print("Yes")
                f=1
        if f==0:
            if l[ind]==n-ind-1 and l[ind-1]==l[ind]:
                print("No")
                f=1
            if f==0:
                for i in range(ind,n):
                    if l[i]>=n-i-1:
                        pass
                    else:
                        f=1
                        break
                if f==0:
                    print("Yes")
                else:
                    print("No")
                    
