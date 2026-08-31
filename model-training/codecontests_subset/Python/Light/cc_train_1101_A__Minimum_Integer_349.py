q=int(input())
search_number=0
for number_string in range (q):
    string=input()
    string_=string.split()
    l=int(string_[0])
    r=int(string_[1])
    d=int(string_[2])
    if l/d>1:
        search_number=d
    elif l//d<=1:
        search_number=d*(r//d+1)
    print(search_number)