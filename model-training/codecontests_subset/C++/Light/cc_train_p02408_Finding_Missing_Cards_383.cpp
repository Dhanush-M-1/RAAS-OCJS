#include<iostream>
using namespace std;

int main(){
 int n,a,t[4][14]={};
 cin >> n;
 char Mark;
 
 for(int i=0;i<n;i++){
  cin >> Mark >> a;
  if(Mark == 'S') t[0][a]++;
  else if (Mark == 'H') t[1][a]++;
  else if (Mark == 'C') t[2][a]++;
  else if (Mark == 'D') t[3][a]++;
 }

 for(int i=0;i<4;i++){
  for(int j=1; j<=13; j++){
   if(t[i][j] == 0){
    if(i == 0) cout << "S " << j <<endl;
    else if(i == 1) cout << "H "<< j <<endl;
    else if(i == 2) cout << "C "<< j <<endl;
    else if(i == 3) cout << "D "<< j <<endl;
   }
  }
 }
}
