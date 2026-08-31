for _ in range(int(input())):
   n = int(input())
   grid = []
   v1 = []
   v0 = []
   for i in range(n):
      r = input()
      grid.append(r)

   st = grid[0][1]+grid[1][0]
   en = grid[n-1][n-2]+grid[n-2][n-1]
   s_z = st.count('0')
   e_z = en.count('0')
   if abs(s_z-e_z)==2:
      print(0)
      continue
   if s_z==e_z:
      print(2)
      if '0' not in st or '1' not in st: 
         print(1,2)
         print(2,1)
         continue
      if grid[0][1]=='0':print(1,2)
      else: print(2,1)
      if grid[n-1][n-2]=='0': print(n-1,n)
      else: print(n, n-1)

   else:
      print(1)
      if '0' not in st:
         if grid[n-1][n-2]=='0': print(n-1,n)
         else: print(n, n-1)
         continue
      if '1' not in st:
         if grid[n-1][n-2]=='1': print(n-1,n)
         else: print(n, n-1)
         continue
      if '0' not in en:
         if grid[0][1]=='0': print(2,1)
         else: print(1,2)
         continue
      if '1' not in en:
         if grid[0][1]=='1': print(2,1)
         else: print(1,2)
         continue

   
      
         

   
