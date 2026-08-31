#include<iostream>
using namespace std;
int main( ){
  int n,y,a[4][13]={};
  char x;
  scanf("%d",&n);
  for(int i=0;i<n;i++){
    cin >> x >> y;
    if(x==83){
      a[0][y-1]=1;
    }
    if(x==72){
      a[1][y-1]=1;
    }
    if(x==67){
      a[2][y-1]=1;
    }
    if(x==68){
      a[3][y-1]=1;
    }
  }
  for(int j=0;j<4;j++){
    for(int s=0;s<13;s++){
      if(a[j][s]==0){
	if(j==0)printf("S %d\n",s+1);
	if(j==1)printf("H %d\n",s+1);
	if(j==2)printf("C %d\n",s+1);
	if(j==3)printf("D %d\n",s+1);
      }
    }
  }
  return 0;
}