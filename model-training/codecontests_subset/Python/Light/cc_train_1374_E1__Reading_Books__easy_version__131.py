n,k = map(int,input().split(' '))

book = [[]for i in range(4)]
s = [[]for i in range(4)]

for i in range(n):
    t,a,b = map(int,input().split(' '))
    book[2*a+b].append(t)

for i in range(1,4):
    book[i].sort()
    s[i].append(0)
    for j in book[i]:
        s[i].append(s[i][len(s[i])-1]+j)


ans = int(2e9+1)

for i in range(min(k+1,len(s[3]))):
    if (k-i < len(s[1]) and k-i < len(s[2])): ans = min(ans,s[3][i]+s[1][k-i]+s[2][k-i])
print(-1 if ans==int(2e9+1) else ans)
  	   	  	 		  		    	     			