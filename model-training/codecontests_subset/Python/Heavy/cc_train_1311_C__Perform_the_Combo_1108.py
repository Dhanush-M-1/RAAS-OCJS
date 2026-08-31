def countGreater(arr, n, k): 
    l = 0
    r = n - 1
  
    # Stores the index of the left most element 
    # from the array which is greater than k 
    leftGreater = n 
  
    # Finds number of elements greater than k 
    while (l <= r): 
        m = int(l + (r - l) / 2) 
  
        # If mid element is greater than 
        # k update leftGreater and r 
        if (arr[m] > k): 
            leftGreater = m 
            r = m - 1
  
        # If mid element is less than 
        # or equal to k update l 
        else: 
            l = m + 1
  
    # Return the count of elements  
    # greater than k 
    return (n - leftGreater) 
def char_position(letter):
    return ord(letter) - 97


t=int(input())
for i in range(t):
	counter=[0]*26
	n,m=map(int,input().split())
	s=input()
	p=list(map(int,input().split()))
	p.sort()
	for i in range(len(s)):
		gr=countGreater(p,len(p),i)
		ta=char_position(s[i])
		#print(ta)
		counter[ta]+=(gr+1)
	print(*counter)