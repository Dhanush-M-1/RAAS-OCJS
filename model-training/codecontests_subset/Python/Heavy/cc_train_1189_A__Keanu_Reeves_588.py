n=int(input())
s=input()
slice=""
slices=""
slicess=""
if n==1:
    print(1)
    print(s)
elif s.count('0')==0 or s.count('1')==0:
    print(1)
    print(s)
elif (s.count('0'))!=(s.count('1')):
    print(1)
    print(s)
elif n==2:
    print(2)
    print(s[:1]+" "+s[1:])
elif n>2:
    for i in range(len(s)):
       slice=s[:i]
       slices=s[i:]
       if (slice.count('0')==slice.count('1')) or (slices.count('0')==slices.count('1')):
            continue
       else:
           print(2)
           print(slice+" "+slices)
           break
else:
    inx =1
    for i in range(len(s)):
        slice = s[:i]
        slicess = s[i:(i+inx)]
        slices = s[(i+inx):]
        inx+=1
        if (slice.count('0') == slice.count('1')) or (slices.count('0') == slices.count('1')):
            if (slicess.count('0') == slicess.count('1')):
                continue
        else:
            print(3)
            print(slice + " "+slicess+" " +slices)
            break
