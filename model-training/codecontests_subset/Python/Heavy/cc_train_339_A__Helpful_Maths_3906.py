str1 = input()
str1_list = list(str1)
lenth = len(str1)
ones = 0
twoes = 0
threes = 0


for i in range(lenth):
    if str1[i] == '1':
        ones = ones+1
    if str1[i] == '2':
        twoes  = twoes +1
    if str1[i] == '3':
        threes = threes+1    

if (ones>0):    
    for _ in range(ones-1):
        print('1',"+",sep="",end="")
    if twoes > 0 or threes > 0 :
        print('1',"+",sep="",end="") 
    else:
         print('1')    
if (twoes > 0):
    for _ in range(twoes-1):
        print('2',"+",sep="",end="")
    if (threes > 0):
        print('2',"+",sep="",end="") 
    else:
        print('2')    
if (threes > 0):
    for _ in range(threes-1):
        print('3',"+",sep="",end="")
    print('3')         