def printFreq(arr,string):
    freqArray=list()
    suffixSum=list()
    n=len(string);
    for i in range(n):
        freqArray.append(0);
        suffixSum.append(0);
    for i in arr:
        freqArray[i]+=1;
    freqArray[n-1]+=1
        
    suffixSum[n-1]=freqArray[n-1]
    i=n-2
    while i>=0:
        suffixSum[i]=suffixSum[i+1]+freqArray[i]
        i-=1
    
    freqArray=list()
    for i in range(26):
        freqArray.append(0)
    
    for i in range(len(string)):
        count=suffixSum[i];
        freqArray[ord(string[i])-97]+=count
    
    ans="";
    for i in range(26):
        ans+=str(freqArray[i])+" "
    
    print(ans)

numTestCases=int(input(''))
while numTestCases>0:
    inputArray=input('').strip().split()
    n=int(inputArray[0])
    m=int(inputArray[1])
    string=input('')
    arr=list()
    inputArray=input('').strip().split()
    for i in inputArray:
        arr.append(int(i)-1)
    printFreq(arr,string)
    numTestCases-=1