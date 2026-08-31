# Program Assignment:  HelpFullMath          
# Name: Fabián Camp Mussa.
# ID: A01378565.
# Date: April 6, 2019
# Description: Xenia the beginner mathematician is a third year student at elementary school. She is now learning the addition operation.
# The teacher has written down the sum of multiple numbers. Pupils should calculate the sum. To make the calculation easier, 
# the sum only contains numbers 1, 2 and 3. Still, that isn't enough for Xenia. She is only beginning to count, 
# so she can calculate a sum only if the summands follow in non-decreasing order. 
# For example, she can't calculate sum 1+3+2+1 but she can calculate sums 1+1+2 and 3+3.
# You've got the sum that was written on the board. Rearrange the summans and print the sum in such a way that Xenia can calculate the sum.

def computeProblem(stringA):
    numbers = []
    result = ""
    for i in stringA:
        if (i == "+"):
            continue
        else:
            numbers.append(i)
    numbers.sort()
    for i in range(len(numbers)):
        result += numbers[i] + "+"
    result = result[0:len(result)-1]
    print(result)

def main():
    a = input("")
    computeProblem(a)

main()