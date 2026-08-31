def count_sort(L):
    maks = max(L)
    count_list = [0 for i in range(maks+1)]
    good_list =[0 for i in range(len(L))] 
    for i in range(len(L)):
        count_list[L[i]] += 1

    for i in range(1,len(count_list)):
        count_list[i] = count_list[i-1]+count_list[i]
    for i in range(len(L)-1,-1,-1):
       good_list[count_list[L[i]]-1] = L[i]
       count_list[L[i]] -= 1
    return good_list
n = input('')
n = [int(i) for i in n.split('+')]    
#l = [1,7,9,3,2,1]

n = count_sort(n)
n = [str(i) for i in n]

print('+'.join(n))