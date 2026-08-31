out="C"
num=int(input())
fifa="Yes"
for i in range (num):
  a=int(input())
  if out=="C" and a==3:
    fifa="No"
    break
  if out=="B" and a==2:
    fifa="No"
    break
  if out=="A" and a==1:
    fifa="No"
    break
  if out=="C" and a==1:
    out="B"
    continue
  if out=="C" and a==2:
    out="A"
    continue
  if out=="B" and a==1:
    out="C"
    continue
  if out=="B" and a==3:
    out="A"
    continue
  if out=="A" and a==2:
    out="C"
    continue
  if out=="A" and a==3:
    out="B"
    continue
print (fifa) 