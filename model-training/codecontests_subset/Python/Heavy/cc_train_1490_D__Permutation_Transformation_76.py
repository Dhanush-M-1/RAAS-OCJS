def aux(element_j, element_k, array_elements, element_c):
    if(element_j == element_k):
        result[element_j] = element_c
        return
    indexBiggest = element_j
    for index in range(element_j, element_k+1):
        if(array_elements[index] > array_elements[indexBiggest]):
            indexBiggest = index
    result[indexBiggest] = element_c
    element_c += 1
    if(element_j <= indexBiggest-1):
        aux(element_j, indexBiggest-1, array_elements, element_c)
    if(element_k >= indexBiggest+1):
        aux(indexBiggest+1, element_k, array_elements, element_c)
 
for index in range(int(input())):
    input_n = int(input())
    input_a = list(map(int, input().split()))
    result = [0 for i in range(input_n)]
    aux(0, input_n-1, input_a, 0)
    print(*result)