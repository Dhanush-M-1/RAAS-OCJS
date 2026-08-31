#include<bits/stdc++.h>
using namespace std;
int main(){
  char mark[]={'S','H','C','D'},c;
  int d[4][13]={0},n,m;
  cin>>n;
  for(int i=1;i<=n;++i){
    cin>>c>>m;
    switch(c){
    case 'S':
      d[0][m-1]=1;
      break;
    case 'H':
      d[1][m-1]=1;
      break;
    case 'C':
      d[2][m-1]=1;
      break;
    case 'D':
      d[3][m-1]=1;
      break;
    }
  }
  for(int i=0;i<4;++i)
    for(int j=0;j<13;++j)
      if(!d[i][j]) cout<<mark[i]<<" "<<j+1<<endl;
  return 0;
}
