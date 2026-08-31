# cook your dish here
# input = open('file.txt').readline

n , k = list(map(int , input().split()))
ali = []
bob = []
both = []
ac , bc = 0 , 0

for __ in range(n):
  t , ai , bi = list(map(int , input().split()))

  if ai == bi and ai == 1:
    both.append(t)
    ac += 1
    bc += 1
  elif ai == 1:
    ali.append(t)
    ac += 1
  elif bi == 1:
    bob.append(t)
    bc += 1


if ac < k or bc < k:
  print(-1)
else:
  ans = 0
  i = 0
  both.sort()
  ali.sort()
  bob.sort()
  bbi = 0
  ai , bi = 0 , 0
  bbl = len(both)
  al = len(ali)
  bl = len(bob)
  while i < k:

    if bbi < bbl and ai < al and bi < bl:
      age = both[bbi]
      pic = ali[ai] + bob[bi]

      if age < pic:
        ans += age
        # both.pop(0)
        bbi += 1
      else:
        ans += pic
        # ali.pop(0)
        # bob.pop(0)
        ai += 1
        bi += 1
      
    elif bbi < bbl:
      ans += both[bbi]
      bbi += 1
    else:
      ans += ( ali[ai] + bob[bi] )
      ai += 1
      bi += 1
    
    i += 1


  print(ans)