q=lambda:map(int,input().split())
qi=lambda:int(input())
qs=lambda:input().split()
n,k=q()
for i in sorted(q())[::-1]:
    if k%i==0:
        print(k//i)
        break