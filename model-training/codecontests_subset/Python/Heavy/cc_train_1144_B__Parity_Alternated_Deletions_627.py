t=int(input(""))
l=[int(x) for x in input().split()]
odd_list = list(filter(lambda x: (x%2 != 0) , l))
if len(odd_list)>0:
    odd_list.sort()
even_list=list(filter(lambda x: (x%2 == 0) , l))
if len(even_list)>0:
    even_list.sort()
if len(odd_list)>len(even_list):
    for i in range(len(even_list)):
        odd_list.pop()
        even_list.pop()
    odd_list.pop()
    if len(odd_list)==0:
        print(0)
    else:
        print(sum(odd_list))
elif len(odd_list)<len(even_list):
    for i in range(len(odd_list)):
        odd_list.pop()
        even_list.pop()
    even_list.pop()
    if len(even_list)==0:
        print(0)
    else:
        print(sum(even_list))
else:
    print(0)
