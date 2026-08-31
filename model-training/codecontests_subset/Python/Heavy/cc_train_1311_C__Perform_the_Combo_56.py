from operator import add
testcase=int(input())
for i in range(testcase):
         n,m=map(int,input().split())
         str1=input()
         li=list(map(int,input().split()))
         li.sort()
         var=0
         temp=[0 for i in range(27)]
         for q in range(n):
                  #print(ord(str1[q])-ord('a')+1)
                  temp[ord(str1[q])-ord('a')+1]+=1
                    
         temp2=temp[:]
         q=n-1 
         track=m-1
         #print(temp)
         while(q>=0):
               if(track<0):
                     break
               #print(track,q,"hello")
               while(q+1 == li[track] and track>=0):
                     #print(temp,temp2,"temp2+temp1")
                     temp=list(map(add,temp,temp2))
                     track-=1 
               else:
                  temp2[ord(str1[q])-ord('a')+1]-=1
                  #print(temp2,"temp2")
               q-=1 
         print(*temp[1:])       
                 