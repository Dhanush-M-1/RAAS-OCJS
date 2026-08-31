ch = input()
n = int(input())

ok = [0, 0]

for _ in range(n):
    s = input()
    if s[0] == ch[1]:
        ok[0] = True
    if s[1] == ch[0]:
        ok[1] = True
    if s == ch:
        ok[0] = True
        ok[1] = True
    
if ok[0] and ok[1]:
    print("YES")
else:
    print("NO")
 	 	  	 	 		 		 					 		 			 		