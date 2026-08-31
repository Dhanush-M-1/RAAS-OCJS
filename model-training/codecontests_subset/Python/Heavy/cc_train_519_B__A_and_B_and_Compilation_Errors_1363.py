# print ("Enter number of compilation errors")
n = int(input())

#  Create dictionaries for all three input sets
dictone = {}
# print ("Enter the first set of error numbers (all on the same line)")
listone = input().split()
for _x in listone:
    x = int(_x)
    if (x in dictone):
        dictone[x] = dictone[x] + 1
    else:
        dictone[x] = 1

     
dicttwo = {}
# print ("Enter the second set of error numbers (all on the same line)") 
listtwo = input().split()
for _x in listtwo:
    x = int(_x)
    if (x in dicttwo):
        dicttwo[x] = dicttwo[x] + 1
    else:
        dicttwo[x] = 1

dictthree = {}
# print ("Enter the third set of error numbers (all on the same line)") 
listthree = input().split()
for _x in listthree:
    x = int(_x)
    if (x in dictthree):
        dictthree[x] = dictthree[x] + 1
    else:
        dictthree[x] = 1


        
#  Compare dictone and dicttwo to find first error
for x, i in list(dictone.items()):
    if (not (x in dicttwo) or dicttwo[x] != i):
        print (x)
        break
        
#  Compare dicttwo and dictthree to find second error
for x, i in list(dicttwo.items()):
    if (not (x in dictthree) or dictthree[x] != i):
        print (x)
        break
    
    
        

    
