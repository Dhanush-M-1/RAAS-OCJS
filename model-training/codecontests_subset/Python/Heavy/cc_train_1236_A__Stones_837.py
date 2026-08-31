for i in range(int(input())):
   a,b,c = input().split()
   a,b,c=int(a),int(b),int(c)
   count=0
   dc = c//2
   if dc>b:
      count += b*3
      b = b-b
      c = c-(2*b)
                    
            
   else:
      b = b-dc
      c = c-(2*dc)
      count += dc*3
                
                
   db = b//2
   if db>a:
      count += a*3
      a = a-a
      b = b-(2*a)
            
   else:
      a = a-db
      b = b-(2*db)
      count += db*3
                
                
   print(count)