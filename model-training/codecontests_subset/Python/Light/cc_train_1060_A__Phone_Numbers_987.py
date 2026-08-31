n=int(input())
s=input()
k=s.count('8')
if(n//11<=k):
    print(n//11)
else:
    print(k)
