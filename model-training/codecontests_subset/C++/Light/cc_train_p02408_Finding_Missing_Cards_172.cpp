#include<iostream>
using namespace std;
int main(){
int a=0;cin>>a;
int c[4][14]={0};
for(int i=0;i<a;i++){
  char z;
  cin>>z;
  int n;
  cin>>n;
  if(z=='S')
c[0][n]=1;
   else if(z=='H')
c[1][n]=1;
   else if(z=='C')
c[2][n]=1;
   else if(z=='D')
  c[3][n]=1;
  
}

for(int i=0;i<4;i++){
  for(int j=1;j<14;j++){
  if(c[i][j]==0){
    char z;
    if(i==0)
    z='S';
    else if(i==1)
    z='H';
      else if(i==2)
    z='C';
      else if(i==3)
    z='D';
    cout<<z<<' '<<j<<'\n';
  }
  }
}
return 0;
}