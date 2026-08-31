import time
length=int(input())
string=input()
length_of_gram=2
dict_gram={}
def find_max(dict_gram):
    max=0
    max_key=''
    for key,value in dict_gram.items():
        if(value>max):
            max=value
            max_key=key
    return max_key
def print_dict(dict_gram):
    for key,value in dict_gram.items():
        print(key+':'+str(value))
for i in range(length-length_of_gram+1):
    curr_string=string[i:i+length_of_gram]
    #print(curr_string)
    if(curr_string in dict_gram.keys()):
        dict_gram[curr_string]=dict_gram[curr_string]+1
    else:
        dict_gram[curr_string]=1
#print_dict(dict_gram)
#start_time=time.time()
key=find_max(dict_gram)
print(key)
#end_time=time.time()
#print('Total required time is '+str(end_time-start_time))