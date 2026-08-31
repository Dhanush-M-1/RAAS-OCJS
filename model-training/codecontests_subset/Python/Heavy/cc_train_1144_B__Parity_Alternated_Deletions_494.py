n = int(input())

l = list(map(int,input().split()))
l.sort()
odd = []
even = []
l.sort()
for i in l:
    if i%2 != 0:
        odd.append(i)
    else:
        even.append(i)
# print(l)
if odd == []:
    print(sum(even[:len(even)-1]))
elif even == []:
    print(sum(odd[:len(odd)-1]))
else:
    if len(odd)>len(even):
        i = len(odd)-1
        j = len(even)-1
        count = 0
        while True:
            if count%2 == 0:
              if odd!=[]:

               odd.pop(i)
               i-=1
              else:
                  break
            else:
              if even!=[]:
                even.pop(j)
                j-=1
              else:
                  break
            count+=1
    else:
        i = len(odd)-1
        j = len(even)-1
        count = 0
        while True:
            if count%2 != 0:
                if odd!=[]:

                    odd.pop(i)
                    i-=1
                else:
                    break
            else:
                if even!=[]:
                    even.pop(j)
                    j-=1
                else:
                    break
            count+=1
    print(sum(even)+sum(odd))

