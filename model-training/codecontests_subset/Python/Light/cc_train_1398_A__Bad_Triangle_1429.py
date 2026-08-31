for _ in range(int(input())):
	n = int(input())
	s = list(map(int,input().split()))
	if s[0]+s[1]<=s[-1]:
	    print(1,2,len(s))
	else:
	    print(-1)