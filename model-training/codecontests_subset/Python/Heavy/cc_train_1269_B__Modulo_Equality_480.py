def my_function(l1, l2):
    li1 = sorted(l1)
    li2 = sorted(l2)
    if li1 == li2:
        return True
    else:
        return False

n, mod = map(int, input().split())
list1 = list(map(int, input().split()))
list2 = list(map(int, input().split()))
possiblesX = set()
for i in range(n):
    possiblesX.add((list2[i] - list1[0]) % mod)

result = 0
for n in possiblesX:
    aux = []
    for k in list1:
        aux.append((k + n) % mod)
    if(my_function(aux, list2)):
        result = n

print(result)

 	 			     							 			   		 	