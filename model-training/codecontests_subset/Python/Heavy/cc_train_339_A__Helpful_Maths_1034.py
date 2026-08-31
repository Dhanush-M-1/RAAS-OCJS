def main():
    #spliting numbers
    sum=str(input()).split("+")
    #initialising
    ones=[]
    twos=[]
    threes=[]
    output = ""
    #finding positions of 1's,2's and 3's (overkill)
    for i in range(len(sum)):
        if sum[i] == "1":
            ones.append(i)
        elif sum[i] == "2":
            twos.append(i)
        else:
            threes.append(i)
    #constructing the output
    for i in ones:
        output = output + "1+"
    for i in twos:
        output = output + "2+"
    for i in threes:
        output = output + "3+"

    output = output[:len(sum)*2-1]
    print(output)



if __name__ == "__main__": main()