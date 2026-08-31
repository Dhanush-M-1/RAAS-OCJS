#KP Code=-> code it one the way #

def check_good(num):
    num1=num
    num=[int(i) for i in num]
    if len(num1)/2==sum(num):
        return False
    return True
z=input()
input_string=(input())
if check_good(input_string):
    print(1)
    print(input_string)
else:
    if len(input_string)<=2:
        print(2)
        print(input_string[:int(len(input_string)//2)],input_string[int(len(input_string)//2):],sep=" ")
    else:
        # print(2)
        # print(input_string[:int(len(input_string)//2)+1],input_string[int(len(input_string)//2)+1:],sep=" ")
        for i in range(0,len(input_string)-1):
            if check_good(input_string[:i+1]) and check_good(input_string[i+1:]):
                print(2)
                print(input_string[:i+1],input_string[i+1:],sep=" ")
                break
