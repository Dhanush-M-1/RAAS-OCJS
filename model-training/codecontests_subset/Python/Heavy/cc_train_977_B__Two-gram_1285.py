class Solution:

    def solve(self, n, s):

        i = 0
        j = 1
        str_list = list(s)
        gram_dict = dict()
        while(j < n):
            
            if(str_list[i]+str_list[j] in gram_dict.keys()):
                gram_dict[str_list[i]+str_list[j]] += 1
            else:
                gram_dict[str_list[i]+str_list[j]] = 1

            i += 1
            j += 1

        max_v = max(gram_dict.values())
        
        for i in gram_dict.keys():
            if gram_dict[i] == max_v:
                return i

if __name__ == '__main__':

    s = Solution()
    
    n = int(input())
    st = input()

    print(s.solve(n,st))

