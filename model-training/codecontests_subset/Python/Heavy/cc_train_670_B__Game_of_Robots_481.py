

def solve():
   mm = list(map(int,input().split()))
   n = mm[0]
   k = mm[1]
   arr = list(map(int,input().split()))
    
   if n == 1:
       print(arr[0])
       return

   mo =1

   for i in range(n):
       if k == 1:
           print(arr[0])
           break
       if i == 0:
           mo = 1
       else:
           tmp = i+1
           if mo+tmp < k:
               mo=mo+tmp
           else:
               ans = k - mo
               ans = ans - 1
               print(arr[ans])
               break


solve()
