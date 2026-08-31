def diversity(s,n):
   if n==0 or n==1:
      return 0
   if n==2:
      if s[0]==s[1]:
         return 1
      else:
         return 0
   count=0
   a=['n']*n
   for i in range(n-2):
      # print(count)
      if s[i]==s[i+1] and a[i]=='n' and a[i+1]=='n':
         count+=1
         a[i+1]='c'
      if s[i]==s[i+2] and a[i]=='n' and a[i+2]=='n':
         count+=1
         a[i+2]='c'
   # print(a)
   if s[-1]==s[-2] and a[-1]=='n' and a[-2]=='n':
      count+=1
   return count

if __name__=='__main__':
   t=int(input())
   for _ in range(t):
      s=input()
      # arr=list(map(int,input().split(' ')))
      print(diversity(s,len(s)))