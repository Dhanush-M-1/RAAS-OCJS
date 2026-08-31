no_of_testcases=int(input())
def convert_to_binary(binary_list):
    length_of_final_list=len(binary_list)
    counter=length_of_final_list-1
    decimal_no=0
    while(counter>=0):
        decimal_no=decimal_no+int(binary_list[counter])*pow(2,length_of_final_list-1-counter)
        counter=counter-1
    return decimal_no
        
def make_same_length(number1,number2):
    len1=len(number1)
    len2=len(number2)
    difference=len1-len2
    if(difference==0):
        return number1,number2
    if(difference>0):
        addition='0'*difference
        return number1,addition+number2
    if(difference<0):
        addition='0'*(-difference)
        return addition+number1,number2
for i in range(no_of_testcases):
    offset={}
    offset['01']=0
    offset['11']=1
    offset['10']=2
    binary_value_list=['1','0','1']
    number1,number2,number_of_additions=list(map(int,input().split(' ')))
    number1=bin(number1).replace('0b','')
    number2=bin(number2).replace('0b','')
    #number_of_additions=int(input())
    number1,number2=make_same_length(number1,number2)
    #print(number1,number2)
    string_list=[]
    for i in range(len(number1)):
        string_list.append(number1[i]+number2[i])
    #print(string_list)
    final_list=[]
    for i in string_list:
        if(i=='00'):
            final_list.append('0')
        else:
            final_list.append(binary_value_list[(offset[i]+number_of_additions+1)%3])
    #print(final_list)
    decimal_no=convert_to_binary(final_list)
    print(decimal_no)
    #print(bin(number).replace('0b',""))
    
    
    
    
    
    
'''
01 1 0 1 1 0 1 1 0 1
11 0 1 1 0 1
10 1 1 0 1 1
00 0 0 0 0 0


'''