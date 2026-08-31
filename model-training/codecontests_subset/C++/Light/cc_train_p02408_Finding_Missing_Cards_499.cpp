#include<iostream>
#include<cstring>
#include<map>
using namespace std;
int main(){
  map<char,int>ll;
  map<int,char>sw;
  ll['S']=0,ll['H']=1,ll['C']=2,ll['D']=3;
  sw[0]='S',sw[1]='H',sw[2]='C',sw[3]='D';

  int n,a;
  char c;
  bool card[4][13];
  memset(card,false,sizeof(card));

  cin >> n;
  for(int i=0;i<n;i++){
    cin >> c >> a;
    card[ll[c]][a-1] = true;
  }
  for(int i=0;i<4;i++){
    for(int j=0;j<13;j++){
      if(!card[i][j]){
	cout << sw[i] << " " << j+1 << endl;
      }
    }
  }
}