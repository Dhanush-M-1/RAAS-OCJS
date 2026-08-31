n=int(input())
a=list(map(int,input().split()))
b=list(map(int,input().split()))
c=list(map(int,input().split()))

a.sort()
b.sort()
c.sort()
status1=True
status2=True

for i in range(len(b)) :
    if a[i]==b[i] :
        continue
    else :
        print(a[i])
        status1=False
        break
if status1 :
    print(a[-1])

for i in range(len(c)) :
    if b[i]==c[i] :
        continue
    else :
        print(b[i])
        status2=False
        break
if status2 :
    print(b[-1])


  		    	 	 			 							 	 	