class XORinacci:
    def __init__(self):
        self.NoOfTestCases = 0
        self.TestCases = []
    def getInputData(self):
        self.NoOfTestCases = int(input())
        testCase = [0,0,0]
        for x in range(self.NoOfTestCases):
            strTestCase = str(input()).split(" ")
            testCase[0] = int(strTestCase[0])
            testCase[1] = int(strTestCase[1])
            testCase[2] = int(strTestCase[2])
            self.TestCases.append(list(testCase))
    def computeXORinacii(self):
        for x in range(self.NoOfTestCases):
            xor = self.TestCases[x][0] ^ self.TestCases[x][1]
            if (self.TestCases[x][2] + 3) % 3 == 0:
                print(self.TestCases[x][0])
            elif (self.TestCases[x][2] + 2) % 3 == 0:
                print(self.TestCases[x][1])
            else:
                print(xor)
            
x = XORinacci()
x.getInputData()
x.computeXORinacii()