from fractions import gcd
for _ in range(int(input())):
 a,b,c,d=list(map(int,input().split()))
 k,p=b*max((a-c-1)//b+1,1),0
 if d<b or a<k:p=1
 elif b<c+2:p=0
 elif b-c>gcd(b,d):p=1
 print("YNeos"[p::2])