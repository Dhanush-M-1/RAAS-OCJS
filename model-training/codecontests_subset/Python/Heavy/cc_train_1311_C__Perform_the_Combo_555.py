


alpha=['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
dic={l:i for i,l in enumerate(alpha)}

t=int(input())
for o in range(t):  
  lixo=input()
  s=list(input())
  v=list(map(int,input().split()))
  aux=[0]*len(s)
  out=[0]*26
  for i in v:
    aux[i-1]+=1
  aux2=0
  for i in range(len(aux)-1,-1,-1):
    aux2+=aux[i]
    out[dic[s[i]]]+=aux2
  for i in s:
    out[dic[i]]+=1
    
  for i in out:
    print(i,end=' ')
  print()

  				 		    		     	   		  			