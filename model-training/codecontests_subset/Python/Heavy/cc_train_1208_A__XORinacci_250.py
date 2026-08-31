class XORinacci:
    def __init__(self):
        self.NoOfTestCases = 0
    def getInputData(self):
        self.NoOfTestCases = int(input())
        testCase = [0,0,0]
        for x in range(self.NoOfTestCases):
            strTestCase = str(input()).split(" ")
            testCase[0] = int(strTestCase[0])
            testCase[1] = int(strTestCase[1])
            testCase[2] = int(strTestCase[2])
            self.computeXORinacii(testCase)
    def computeXORinacii(self,testCase):
        xor = testCase[0] ^ testCase[1]
        if (testCase[2]) % 3 == 0:
            print(testCase[0])
        elif (testCase[2]) % 3 == 1:
            print(testCase[1])
        else:
            print(xor)
            
x = XORinacci()
x.getInputData()