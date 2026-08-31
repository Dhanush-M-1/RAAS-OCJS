#A. Common Subsequence
CaseNo = int(input())

for x in range(CaseNo):
  Length = input().split()
  LenA = int(Length[0])
  LenB = int(Length[1])
  StringA = [int (a) for a in input().split()]
  StringB = [int (b) for b in input().split()]
  StringNew = list()
  for y in range(LenA):
    if StringA[y] in StringB:
      StringNew.append(StringA[y])
      break
  
  LenNew = len (StringNew)
  if LenNew > 0:
    LenValue = StringNew[0]
    print ("YES")
    print (1, LenValue)
  else:
    print ("NO")
  

