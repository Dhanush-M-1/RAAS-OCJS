
days = [31,28,31,30,31,30,31,31,30,31,30,31]
d = []
for i in range(1,32):
   if i<10:
    d.append('0'+str(i))
   else:
       d.append(str(i))
mon = []
hash_mo = {}
for i in range(1,13):
    hash_mo[i] = days[i-1]
for i in range(1,13):
    if i<10:
        mon.append('0'+str(i))
    else:
        mon.append(str(i))
# print(mon)
lis = ['2013','2014','2015']
k = input()
posn = []

for i in range(1,len(k)):
    if k[i] == '-' :
        posn.append(i)
# print(posn)
hash = {}
for i in range(len(posn)-1):
  if posn[i+1] - posn[i] == 3:
   m = posn[i]
   if 0<=m-2<=len(k)-1 and 0<=m-1<=len(k)-1 and 0<=m<=len(k)-1 and 0<=m+2<=len(k)-1 and 0<=m+3<=len(k)-1 and 0<=m+4<=len(k)-1:
     if k[m+4:m+8] in lis:
     #  print(k[posn[m+1]+1:4])
      day = k[m-2] + k[m-1]

      month = k[m+1] + k[m+2]
      # print(day,month)
      if month in mon and day in d:
       if int(day)<=hash_mo[int(month)]:
        s = k[m-2] + k[m-1] + k[m] + k[m+1] + k[m+2] + k[m+3] + k[m+4:m+8]

        try:
          hash[s]
        except:
          hash[s] = 1
        else:
          hash[s]+=1
max = 0

for i in hash.keys():
    if hash[i]>max:
        max = hash[i]
        yo  = i
print(yo)
