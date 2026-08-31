numbers = input()
a, b = numbers.split(" ")
a = int(a)
b = int(b)
c = b-a
list1 = []
if c<10000:
    if a<10000:    
        for i in range(c+1):
            doke = a + i
            list1.append(doke)
            for ii in range(2, (doke+1)//2):
                if doke%ii==0:
                    list1.append(ii)
        list1.sort()
        list2=[]
        for i in range(len(list1)):
            nu = list1.count(list1[i])
            list2.append(nu)
        ma = max(list2)
        ind = list2.index(ma)
        answer = list1[ind]
    else:
        for i in range(c+1):
            doke = a + i
            list1.append(doke)
            for ii in range(2, 100):
                if doke%ii==0:
                    list1.append(ii)
        list1.sort()
        list2=[]
        for i in range(len(list1)):
            nu = list1.count(list1[i])
            list2.append(nu)
        ma = max(list2)
        ind = list2.index(ma)
        answer = list1[ind]
else: answer=2
print(answer)
