if __name__== '__main__':
    testCases= int(input())
    for _ in range(testCases):
        n, m= map(int,input().split())
        As= input()
        Ps= list(map(int,input().split()))

        Ps.append(n)
        frequency= [0]* n
        for mistakeIndex in Ps:
            frequency[mistakeIndex-1]+= 1
        
        #From 2nd last index to 0
        for index in range(n-2, -1, -1):
            frequency[index]= frequency[index]+ frequency[index+ 1]

        answer=[0]*26
        for index in range(n):
            answer[ord(As[index])-97]+= frequency[index]

        print(*answer)