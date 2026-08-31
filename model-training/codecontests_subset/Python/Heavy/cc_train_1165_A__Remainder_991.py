
length_of_number = 0
exp_of_remainder = 0
exp_of_modulo = 0
number = ""
count = 0

def Input(length_of_number, exp_of_remainder, exp_of_modulo, number):
    arr = list(map(int,input().split()))
    length_of_number = arr[0]
    exp_of_modulo = arr[1]
    exp_of_remainder = arr[2]
    number = str(input())

    return length_of_number, exp_of_remainder, exp_of_modulo, number

def Processing(length_of_number, exp_of_remainder, exp_of_modulo, number, count):
    for index in range(length_of_number - exp_of_modulo,length_of_number):
        if index == (length_of_number - exp_of_remainder - 1):
            if number[index] != "1":
                count += 1
        else:
            if number[index] != "0":
                count += 1

    return length_of_number, exp_of_remainder, exp_of_modulo, number, count

def Output(count):
    print(count)

if __name__ == "__main__":
    length_of_number, exp_of_remainder, exp_of_modulo, number = Input(length_of_number, exp_of_remainder, exp_of_modulo, number)    
    length_of_number, exp_of_remainder, exp_of_modulo, number, count = Processing(length_of_number, exp_of_remainder, exp_of_modulo, number, count)
    Output(count)