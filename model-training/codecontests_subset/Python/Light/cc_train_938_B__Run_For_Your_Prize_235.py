n = int(input())
a = [int(x) for x in input().strip().split(' ')]
friend = 1000000
me = 0
for i in a:
    if i <= 500000:
        if i > me:
            me = i
    else:
        if friend > i:
            friend = i
ans = me - 1
if ans < 1000000-friend:
    ans = 1000000-friend
print(ans)
	 			  	 		   		  						 	  	 	