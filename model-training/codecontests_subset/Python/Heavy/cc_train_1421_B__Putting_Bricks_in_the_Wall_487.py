from sys import stdin,stdout


ans = []
def main():
    n = int(stdin.readline())
    arr = [list(stdin.readline())[:-1] for _ in range(n)]
    sr,sb,fl,ft= [int(arr[0][1]),int(arr[1][0]),int(arr[-1][-2]),int(arr[-2][-1])]
    count =0
    sumval = int(sr) + int(sb)+int(fl)+int(ft)
    
    if sumval == 4 or sumval == 0:
        ans.append(str(2))
        ans.append('1 2')
        ans.append('2 1')
        return
    
    if sumval == 2:
        if sr == sb:
            ans.append('0')
            return
        if sr == fl:
            ans.append('2')
            ans.append('1 2')
            ans.append(str(n-1) +' '+str(n))
        else:
            ans.append('2')
            ans.append('1 2')
            ans.append(str(n) +' '+str(n-1))
    
    if sumval == 1 or sumval == 3:
        check = 1 if sumval == 1 else 0
        ans.append('1')
        if sr == check:
            ans.append('2 1')
        if sb == check:
            ans.append('1 2')
        if fl == check:
            ans.append(str(n-1) + ' ' + str(n))
        if ft == check:
            ans.append(str(n) + ' ' + str(n-1))
        return


if __name__== '__main__':
    for i in range(int(stdin.readline())):
        main()

    stdout.write('\n'.join(ans))
