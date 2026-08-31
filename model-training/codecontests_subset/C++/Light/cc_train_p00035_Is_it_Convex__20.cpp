#include <iostream>
#include <utility>
#include <cstdio>
#include <cmath>

using namespace std;

typedef struct{
    float x,y;
} P;

bool judge(P p1,P p2,P p3,P px){
    float s,a,b,c;
    s=0.5*abs((p1.x-p3.x)*(p2.y-p3.y)-(p2.x-p3.x)*(p1.y-p3.y));
    a=0.5*abs((p1.x-px.x)*(p2.y-px.y)-(p2.x-px.x)*(p1.y-px.y));
    b=0.5*abs((p2.x-px.x)*(p3.y-px.y)-(p3.x-px.x)*(p2.y-px.y));
    c=0.5*abs((p3.x-px.x)*(p1.y-px.y)-(p1.x-px.x)*(p3.y-px.y));
    if(s==a+b+c||(s+0.001<=a+b+c&&s-0.001>=a+b+c)){
        return true;
    }
    return false;
}

int main(void){
    P p[4];
    int i;
    bool flag;
    
    while(true){
        flag=true;
        for(i=0;i<4;i++){
            if(scanf("%f,%f,",&p[i].x,&p[i].y)==EOF)return 0;
        }
        if(judge(p[0],p[1],p[2],p[3])==false){
            if(judge(p[1],p[2],p[3],p[0])==false){
                if(judge(p[2],p[3],p[0],p[1])==false){
                    if(judge(p[3],p[0],p[1],p[2])==false){
                        cout<<"YES"<<endl;
                        flag=false;
                    }
                }
            }
        }
        if(flag){
            cout<<"NO"<<endl;
        }
    }
}