n=int(input())
str=input()
result=str.count('8')
ans=0
while n>=11 and result>0:
    if n>=11 and result>0:
        ans+=1
        #print('ans: ',ans)
        n-=11
        #print('n: ',n)
        result-=1
        #print('result: ',result)
    else:
        break
print(ans)