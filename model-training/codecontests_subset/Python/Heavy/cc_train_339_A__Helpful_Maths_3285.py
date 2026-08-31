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

if __name__ == "__main__":

    main()

