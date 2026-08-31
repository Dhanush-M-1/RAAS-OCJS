testCases= int(input())
for _ in range(testCases):

    answer= 'YES'
    answerNoted= True
    records= []
    n= int(input())

    for index in range(n):
        record= list(map(int, input().split()))

        if(index== 0):
            if((record[0]< record[1]) and (answerNoted)):
                answer= 'NO'
                answerNoted= False

        else:
            if((record[0]< record[1]) and (answerNoted)):
                answer= 'NO'
                answerNoted= False

            elif(((records[-1][0]> record[0]) or (records[-1][1]> record[1])) and (answerNoted)):
                answer= 'NO'
                answerNoted= False

            elif((records[-1][0]== record[0]) and (records[-1][1]< record[1]) and (answerNoted)):
                answer= 'NO'
                answerNoted= False
            
            elif(((record[0]- records[-1][0]) < (record[1]- records[-1][1])) and (answerNoted)):
                answer= 'NO'
                answerNoted= False

        records.append(record)

    print(answer)
   