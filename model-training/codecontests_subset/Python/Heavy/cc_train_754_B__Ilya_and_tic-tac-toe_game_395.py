def t(s):
    if s.find("xx.")!=-1 or s.find(".xx")!=-1 or s.find("x.x")!=-1:
        return True
    else:
        return False
s1=input()
s2=input()
s3=input()
s4=input()
s5=s1[0]+s2[0]+s3[0]+s4[0]
s6=s1[1]+s2[1]+s3[1]+s4[1]
s7=s1[2]+s2[2]+s3[2]+s4[2]
s8=s1[3]+s2[3]+s3[3]+s4[3]
s9=s1[0]+s2[1]+s3[2]+s4[3]
p1=s1[3]+s2[2]+s3[1]+s4[0]
p2=s1[1]+s2[2]+s3[3]
p3=s2[0]+s3[1]+s4[2]
p4=s1[2]+s2[1]+s3[0]
p5=s2[3]+s3[2]+s4[1]
if t(s1) or t(s2) or t(s3) or t(s4) or t(s5) or t(s6) or t(s7) or t(s8) or t(s9) or t(p1) or t(p2) or t(p3) or t(p4) or t(p5):
    print("YES")
else:
    print("NO")
