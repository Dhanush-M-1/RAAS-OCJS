for _ in range(int(input())):
   l,r,d = [int(i) for i in input().split()]
   print(d if d < l else (r // d+1)*d)