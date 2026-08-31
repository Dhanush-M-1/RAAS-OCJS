s = input()
#create a list to store the numbers in the sum
numbers = []

if len(s) <= 100:
    if len(s) == 1:
        print(s)

    else:
        #append the numbers to the list
        for i in range(0,len(s)):
            if s[i] != "+":
                numbers.append(s[i])

        #sorting the list in non-decreasing order
        ordered = sorted(numbers)

        # print the final sum in non-decreasing order
        sum = ordered[0]
        for a in range(len(ordered) - 1):
            b = ordered.pop(1)
            sum = sum + "+" + b
        print(sum)