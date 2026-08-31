import sys 

def most_common(alist):
    return max(set(alist), key = alist.count)

def main():
    n = int(input())
    s = str(input()).upper()

    #check the number constrains and if the number equals the length of the string
    if 2 >= n >= 100 or n != len(s):
        print('please check the constrains')
        sys.exit()
    
    two_grams = []

    for i in range(n - 1):
        new_string = s[i] + s[i + 1]
        two_grams.append(new_string)
        
    print(most_common(two_grams))




main()