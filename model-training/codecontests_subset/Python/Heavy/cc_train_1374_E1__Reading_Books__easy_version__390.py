n,k = map(int,input().split(' '))
x = [40000]
y = [40000]
z = [40000]
c = d = 0
for i in range(n):
    t,a,b = map(int,input().split(' '))
    if (a==1 and b==1): 
        z.append(t)
        c+=1
        d+=1
    elif (a==1): 
        x.append(t)
        c+=1
    elif (b==1): 
        y.append(t)
        d+=1
if (c<k or d<k): print(-1)
else:
    x.sort(reverse=True)
    y.sort(reverse=True)
    z.sort(reverse=True)
    c = d = ans = 0
    while (c<k or d<k):
        if (c<k and d<k):
            if (x[len(x)-1]+y[len(y)-1]<z[len(z)-1]):
                ans+=(x[len(x)-1]+y[len(y)-1])
                x.pop()
                y.pop()
            else:
                ans+=z[len(z)-1]
                z.pop()
            c+=1
            d+=1
        elif (c<k):
            if (x[len(x)-1]<z[len(z)-1]): 
                ans+=x[len(x)-1]
                x.pop()
            else: 
                ans+=z[len(z)-1]
                z.pop()
            c+=1
        else:
            if (y[len(y)-1]<z[len(z)-1]):
                ans+=y[len(y)-1]
                y.pop()
            else: 
                ans+=z[len(z)-1]
                z.pop()
            d+=1
    print(ans)
  		 			 	  	 			 		      			