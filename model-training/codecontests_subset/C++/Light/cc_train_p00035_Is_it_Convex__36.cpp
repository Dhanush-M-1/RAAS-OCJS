#include<iostream>
#include<cstdio>
#include<cmath>
using namespace std;
int main(){
  double dot[5][2],vec[4][2],edge[4],ang[4],all;
  for(;;){
    if(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&dot[0][0],&dot[0][1],&dot[1][0],&dot[1][1],&dot[2][0],&dot[2][1],&dot[3][0],&dot[3][1]) == EOF){break;}
    dot[4][0] = dot[0][0];
    dot[4][1] = dot[0][1];
    for(int i=0; i<4; i++){
      vec[i][0] = dot[i+1][0]-dot[i][0];
      vec[i][1] = dot[i+1][1]-dot[i][1];
      edge[i] = sqrt(vec[i][0]*vec[i][0]+vec[i][1]*vec[i][1]);
    }
    ang[0] = acos(-(vec[0][0]*vec[3][0]+vec[0][1]*vec[3][1])/(edge[0]*edge[3]));
    ang[1] = acos(-(vec[1][0]*vec[0][0]+vec[1][1]*vec[0][1])/(edge[1]*edge[0]));
    ang[2] = acos(-(vec[2][0]*vec[1][0]+vec[2][1]*vec[1][1])/(edge[2]*edge[1]));
    ang[3] = acos(-(vec[3][0]*vec[2][0]+vec[3][1]*vec[2][1])/(edge[3]*edge[2]));
    all = ang[0]+ang[1]+ang[2]+ang[3];
    if(all < 6.283){cout <<"NO"<<endl;}
    else{cout <<"YES"<<endl;}
  }
  return 0;
}