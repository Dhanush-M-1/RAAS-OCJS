import itertools

def testcases(a,n):
    #x,y,z=0,1,n-1
    """for i in range(n-2):
        #z=n-1
        for j in range(i+1,n-1):
            z=n-1
            while(z>j):
                if a[i]+a[j]<a[z]:
                    return i+1,j+1,z+1
                else:
                    z-=1
    return -1"""
    if a[0]+a[1]<=a[n-1]:
        return 1,2,n
    else:
        return -1

for _ in range(int(input())):
    n=int(input())

    #p=[int(x) for x in input().split()]
    a=[int(x) for x in input().split()]
    ans=(testcases(a,n))
    if ans==-1:
        print(-1)
    else:
        """ans=list(ans)
        if ans[0]==ans[1]:
            ans[1]+=1
        elif ans[0]==ans[2]:
            ans[2]+=1
        elif ans[1]==ans[2]:
            ans[2]+=1"""
        for i in ans:
            print(i,end=" ")
        print()