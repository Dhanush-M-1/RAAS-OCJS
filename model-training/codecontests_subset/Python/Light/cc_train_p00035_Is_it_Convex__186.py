class Vector2:
    """
    A simple 2D vector class.
    @Author:whitestone0811(Vir_MeL0)
    """
    def __init__(self,x,y):
        self.x=x
        self.y=y
    def __add__(self,other):
        return Vector2(self.x+other.x,self.y+other.y)
    def __sub__(self,other):
        return Vector2(self.x-other.x,self.y-other.y)
    def __mul__(self,other):
        if isinstance(other, Vector2):
            return self.x*other.x+self.y*other.y
        else:
            return Vector2(self.x*other,self.y*other)
    def __rmul__(self,other):
        if not isinstance(other,Vector2):
            return Vector2(self.x*other,self.y*other)
    def abs(self):
        return (self.x**2+self.y**2)**0.5
    def cos(self,other):
        return (self*other)/(self.abs()*other.abs())
    def __str__(self):
        return "[{0},{1}]".format(self.x,self.y)
    def __neg__(self):
        return Vector2(-self.x,-self.y)
#  
import sys  
lines=sys.stdin
for _in in lines:
    cors=[float(cor)for cor in _in.split(',')]
    vAB=Vector2(cors[2]-cors[0],cors[3]-cors[1])
    vBC=Vector2(cors[4]-cors[2],cors[5]-cors[3])
    vCD=Vector2(cors[6]-cors[4],cors[7]-cors[5])
    vDA=Vector2(cors[0]-cors[6],cors[1]-cors[7])
    cnv_a=True if(vAB-vDA)*(vAB+vBC)>0 else False
    cnv_b=True if(vBC-vAB)*(vBC+vCD)>0 else False
    cnv_c=True if(vCD-vBC)*(vCD+vDA)>0 else False
    cnv_d=True if(vDA-vCD)*(vDA+vAB)>0 else False
    print("YES" if cnv_a and cnv_b and cnv_c and cnv_d else "NO")