def check(k , s):
        letters = dict()
        result = -1
        string = str()
        
        for i in range(97 , 123):
                letters[chr(i)] = 0

        for i in s:
                letters[i] += 1

        values = list(letters.values())
        for i in values:
                if i % k != 0:
                        return result
                
        for i in letters:
                value = letters[i]
                value = value // k
                string += i * value

        return (string * k)
                
if __name__ == "__main__":
        k = int(input().rstrip())
        s = input().rstrip()

        print (check(k , s))
