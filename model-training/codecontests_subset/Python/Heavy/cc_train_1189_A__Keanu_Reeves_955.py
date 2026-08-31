n=int(input())
s=input()
if n%2==0:
    if s.count("0")==s.count("1"):
        print(2)
        print(s[0],s[1:])
    else:
        print(1)
        print(s)
else:
    if n==1:
        print(1)
        print(s)
    elif s.count("0")!=s.count("1"):
        print(1)
        print(s)
    else:
        for i in range(1,n):
            s1=s[:i]
            s2=s[i:]
            #print(s1,s2)
            if (s1.count("1")!=s1.count("0") and s2.count("1")!=s2.count("0")):
                print(2)
                print(s1,s2)
                break

		  			  	 	 			 	  			 				