def divide(arr,x,output):
    parts = []
    largest_index = arr.index(max(arr))
    parts.append(list(arr[0:largest_index]))
    parts.append(list(arr[largest_index+1:len(arr)]))
    output[arr[largest_index]]=x
    if len(parts[0])>0:
        divide(parts[0],x+1,output)
    if len(parts[1])>0:
        divide(parts[1],x+1,output)
    return output
def main():
    np = int(input(""))
    permutations = []
    for x in range(0, np):
        leng=input("")
        permutation = input("")
        permutations.append(list(map(int, permutation.split(' '))))
    for x in range(0, len(permutations)):
       out =divide(permutations[x],0,{})
       for y in range(0,len(permutations[x])):
           print(out[int(permutations[x][y])],' ',end='')
       print('')
if __name__ == "__main__":
    main()