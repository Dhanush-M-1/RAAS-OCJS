def main():
    for _ in range(int(input())):
        n=int(input())
        a=[]
        for i in range(n):
            a.append(input())
        ans=[]
        
        if a[0][1]==a[1][0]:
            if a[n-1][n-2]==a[0][1]:
                ans.append((n,n-1))
            if a[n-2][n-1]==a[0][1]:
                ans.append((n-1,n))
        elif a[n-1][n-2]==a[n-2][n-1]:
            if a[0][1]==a[n-1][n-2]:
                ans.append((1,2))
            if a[1][0]==a[n-1][n-2]:
                ans.append((2,1))
        else:
            ans.append((1,2))
            if a[n-1][n-2]==a[1][0]:
                ans.append((n,n-1))
            if a[n-2][n-1]==a[1][0]:
                ans.append((n-1,n))
        
        print(len(ans))
        for a,b in ans:
            print("%d %d"%(a,b))
main()