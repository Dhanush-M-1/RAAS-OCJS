import sys
def find_max_element_index(array_elements,min_index,max_index):
    max_value=array_elements[min_index]
    max_value_index=min_index
    for i in range(min_index+1,max_index+1):
        if array_elements[i]>max_value:
            max_value=array_elements[i]
            max_value_index=i
    return max_value_index
def find_depths(array_elements,min_index,max_index,level_now,level_dict):
    if max_index<min_index:
        return
    max_element_index=find_max_element_index(array_elements,min_index,max_index)
    level_dict[array_elements[max_element_index]]=level_now
    find_depths(array_elements,min_index,max_element_index-1,level_now+1,level_dict)
    find_depths(array_elements,max_element_index+1,max_index,level_now+1,level_dict)
inputlines=sys.stdin.readlines()
number_of_testcases=int(inputlines[0])

for i in range(number_of_testcases):
    number_of_elements=int(inputlines[2*i+1])
    array_elements=list(map(int,inputlines[2*i+2].split(' ')))
    level_dict={}
    find_depths(array_elements,0,number_of_elements-1,0,level_dict)
    '''
    for key,value in level_dict.items():
        print(key,':',value)
    '''
    for i in array_elements:
        print(level_dict[i],end=" ")
    print('')