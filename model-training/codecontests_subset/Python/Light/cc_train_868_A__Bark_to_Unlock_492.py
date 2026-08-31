def f():
    a,n,s=list(input()),int(input()),[]
    for i in range(n):
        s.append(list(input()))
    for i in s:
        if i==a:
            return "YES"
        elif i[1]==a[0]:
            for j in s:
                if j[0]==a[1]:
                    return "YES"
    return "NO"
print(f())
		 	 				 			 	    	  	  		 	