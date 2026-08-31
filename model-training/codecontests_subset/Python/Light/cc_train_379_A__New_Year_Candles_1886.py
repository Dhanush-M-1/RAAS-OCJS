a,b=map(int,input().split())
ans=0
while(a>=b):
    a-=b
    ans+=b
    a+=1
ans+=a
print(ans)

 			  	 			    			   	 		  	