r1,r2 = map(int, input().split())
c1,c2 = map(int, input().split())
d1,d2 = map(int, input().split())
done = 0
for a1 in range(1,10):
 	a2 = r1 - a1
 	if a2 < 1 or a2>9 or a2== a1: 
 		continue
 	a3 = c1 - a1
 	if a3 < 1 or a3>9 or a3 == a1 or a3==a2: 
 		continue
 	a4 = c2 - a2
 	if a4 < 1 or a4>9 or a4==a1 or a4 == a2 or a4==a3: 
 		continue
 	if a1+a4 != d1:
 	    continue
 	if a2+a3 != d2 :
 	    continue
 	if a3+a4 != r2 :
 	    continue 
 	print(a1,a2)
 	print(a3,a4)
 	done=1
 	break
if done==0:
 	print(-1)

# Wed Oct 14 2020 14:04:54 GMT+0300 (Москва, стандартное время)
