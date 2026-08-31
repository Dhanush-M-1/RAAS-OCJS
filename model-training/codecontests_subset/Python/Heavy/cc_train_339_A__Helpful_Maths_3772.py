class solution():
    

    def __init__(self,list1):
        self.list1 = list1
        self.list2 = []
        self.list3 = ['1','2','3']
        del list1
        self.i = 0
        self.j = 0
        self.k = 0
        self.dict1 = {'1': self.one(),'2': self.two(),'3': self.three()}
        
    def rd_list(self):
        for i in self.list3:
            self.dict1[i]
    
    def wt_list(self):
        for i in range(self.i):
            self.list2.append('1')
            self.list2.append('+')
            
        for i in range(self.j):
            self.list2.append('2')
            self.list2.append('+')

        for i in range(self.k):
            self.list2.append('3')
            self.list2.append('+')
        self.list2.pop()
    
    def prt_list(self):
        for i in self.list2:
            print(i,end='')
        print('')

    def one(self):
        for i in self.list1:
            if i == '1':
                self.i+=1

    def two(self):
        for i in self.list1:
            if i == '2':
                self.j+=1

    def three(self):
        for i in self.list1:
            if i == '3':
                self.k+=1

    def execute(self):
        self.rd_list()
        self.wt_list()
        self.prt_list()
        
def main():
    str1 = input()
    list1 = str1.split('+')
    s1 = solution(list1)
    s1.execute()
    
if __name__ == '__main__':
    main()
    