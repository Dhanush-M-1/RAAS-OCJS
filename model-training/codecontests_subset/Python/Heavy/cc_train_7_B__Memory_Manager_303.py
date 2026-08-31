def main():
  numberOfCommands, totalMemory = map(int, input().split())
  #I will mark erase operation with a negative number, in order to differenceate it from alloc
  #also the defragment will be marked with 0, as we don't have any alloc or erase with 0
  operations = []
  memory = [0]*totalMemory
  #get the input 
  for _ in range(numberOfCommands):
    inputOperation = input().split()
    if inputOperation[0] == 'alloc':
      #if alloc we store is at it is
      operations.append(int(inputOperation[1]))
    elif inputOperation[0] == 'erase':
      #if erase, there are 2 cases if erase argument is negative, than we replace it with a very big negative number
      if int(inputOperation[1]) <= 0:
        operations.append(-100000000000000000) 
      else:#if it is positive write it as a negative number
        operations.append(-int(inputOperation[1])) 
    else:#else if the operation is 'defragment' just append 0
      operations.append(0)
  #this variable will keep track of the number of memory block
  allocNumber = 1
  #for each operation 
  for operation in operations:
    #if operation is positive, this means that we have alloc case
    if operation > 0:
      #know we have to check if we have operation number of consecutive empty memory blocks
      i = 0
      consecutiveEmpty = 0
      while i < len(memory):
        if memory[i] == 0:
          consecutiveEmpty += 1
          #if we found the necessary number of consecutive empty blocks, then stop
          if consecutiveEmpty == operation:
            break
        #if there is at least one non-zero block in the memory but the consconsecutiveEmpty is not 
        #equal to the number of blocks which we want to allocate then we start counting from 0 once again
        else:
          consecutiveEmpty = 0
        i += 1
      #if we found the necessary number of consecutive empty cells
      if consecutiveEmpty == operation:
        #we fill this consecutiveEmpty blocks of memory with allocNumber
        while consecutiveEmpty - 1 >= 0:
          memory[i - consecutiveEmpty + 1] = allocNumber
          consecutiveEmpty -= 1
        #and we print the alloc number
        print(allocNumber)
        #after this we increase it by one
        allocNumber += 1
      #if we couldn't fined the necessary number of consecutive empty blocks
      #print NULL
      else:
        print('NULL')
    #if the operation is 'erase'
    elif operation < 0:
      #if this block is in memory
      if abs(operation) in memory:
        #change the value of those blocks with 0
        memory = list(map(lambda bit: bit if bit != abs(operation) else 0, memory))
      else:
        print('ILLEGAL_ERASE_ARGUMENT')
    #if the operation is 'defragment'
    elif operation == 0:
      #remove all 0 from the memory
      while 0 in memory:
        memory.remove(0)
      #then add 0's to the end of the list until the memory reaches its initial size
      while len(memory) < totalMemory:
        memory.append(0)

main()