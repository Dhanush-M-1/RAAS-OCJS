n = int(input());
s = input();
a = s.count("0");
b = s.count("1");
aa = 0;
ab = 0;
ba = a;
bb = b;
if(ba!=bb):
    print(1);
    print(s);
else:
    for i in range(n):
        if(s[i]=="0"):
            aa+=1;
            ba-=1;
            if(aa!=ab and ba!=bb):
                print(2);
                print(s[0:i+1],s[i+1:])
                break;
        else:
            ab=+1;
            bb-=1;
            if(aa!=ab and ba!=bb):
                print(2);
                print(s[0:i+1],s[i+1:])
                break;
    
    
