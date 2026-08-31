s = input()
n = s.rfind("#")
error = 0
s1 = 0
s2 = 0
s3 = 0
s4 = s.count("(")
s5 = s.count(")")
s6 = 0
for num in range(n):
   if s[num]=="(" :
      s2 += 1
   elif s[num]==")":
      s3 += 1
   if s[num]=="#" :
         s1 += 1
         s3 += 1
   if s3 > s2:
      error=1
if s1+s5 < s4:
      s6 = s4-s5-s1
      s3 += s6
else:
   error = 1
for num in range(n,len(s)):
   if s[num]=="(" :
      s2 += 1
   elif s[num]==")":
      s3 += 1
   if s3 > s2:
      error=1
if error == 1:
   print(-1)
else:
   while s1>0:
      print(1)
      s1-=1
   print(s6)
   
