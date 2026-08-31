def Array(String):
    List = String.split(' ')
    for i in range(len(List)):
        List[i] = int(List[i])
    return List

def Shortest_sub(Array1,Array2):
    Found = False
    for i in range(len(Array1)):
        for j in range(len(Array2)):
            if Array1[i] == Array2[j]:
                Found = True
                Term = Array1[i]
                break
        if Array1[i] == Array2[j]:
            break
    if Found == True:
        print('YES')
        print('1 '+str(Term))
    else:
        print('NO')
                           

trials = int(input(''))
for i in range(trials):
    input('')
    List1 = Array(input(''))
    List2 = Array(input(''))
    Shortest_sub(List1,List2)

