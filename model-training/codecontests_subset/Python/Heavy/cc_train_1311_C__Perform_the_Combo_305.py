t = int(input())

def solve(n,m,p,s):
        p += [n]
        a = [[0 for j in range(-1,n+1)] for i in range(27)]
        a[ord(s[0])-97][0] = 1
        for i in range(1,n):
                for j in range(27): a[j][i] = a[j][i-1]
                
                a[ord(s[i])-97][i] +=1
                        
        for i in range(26):
                res = 0
                for j in range(m+1): res += a[i][p[j]-1]
                print (res,end=' ')
        print('\n')
                

while t>0:
        t -= 1
        n,m = map(int,input().split())
        s = str(input())
        y = input()
        p = [int(i) for i in y.split()]
        solve(n,m,p,s)
        
