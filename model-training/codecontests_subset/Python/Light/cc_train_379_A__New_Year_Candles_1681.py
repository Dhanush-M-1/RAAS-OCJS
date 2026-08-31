sviecok, mrtvych = map(int, input().split())
naviac, hodin = sviecok // mrtvych, 0

while naviac > 0:
    naviac = sviecok // mrtvych
    hodin += sviecok - (sviecok % mrtvych)
    sviecok %= mrtvych
    sviecok += naviac
    
else:
    hodin += sviecok

print(hodin)
