def main():

    input_sum = input()
    list_of_numbers = []

    for val in input_sum:

        if val != "+":

            list_of_numbers.append(val)

    list_of_numbers = sorted(list_of_numbers)

    output_string = ""
    for i in range(len(list_of_numbers)):

      if i != len(list_of_numbers) -1 :
        output_string = output_string + str(list_of_numbers[i]) + "+"
      else:
        output_string = output_string + str(list_of_numbers[i])

      
    
    print(output_string)

def sec_main():

    count1 = 0
    count2 = 0
    count3 = 0

    input_sum = input()

    for val in input_sum:

        if val != "+":

            if int(val) == 1:
                count1+=1
            elif int(val) == 2:
                count2+=1
            else:
                count3+=1
    
    output_sum = "1+"*count1 + "2+"*count2 + "3+"*count3
    output_sum = output_sum[0:-1]
    print(output_sum)

if __name__ == "__main__":

    #main()

    sec_main()

