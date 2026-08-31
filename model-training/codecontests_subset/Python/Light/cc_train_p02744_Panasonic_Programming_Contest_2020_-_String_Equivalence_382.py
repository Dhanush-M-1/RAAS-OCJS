

def dfs(string,n):
    if len(string)==n:
        print(string)
    else:
        s=string
        for i in range(97,max([ord(j)for j in string])+2):
            dfs(string+chr(i),n)
        

dfs("a",int(input()))