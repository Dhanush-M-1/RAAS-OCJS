#include <iostream>
#include <math.h>
using namespace std;
int DivideMul(int N,int a){
  int L=N%(int)pow(10,a);
  int U=(N-L)/pow(10,a);
  return L*U;
}

int Next(int N){
  int n=0;
  double s=log(N)/log(10);
  for(int i=1;i<s;++i){
      n=max(n,DivideMul(N,i));
  }
  return n;
}


int main(){
  int T;
  cin >> T;
  for(int i=0; i<T; ++i){
    
    int N;
    cin >> N;
    if(N==0){
      cout << 0 << endl;;
      break;
    }

    int j=0;
    for( j=0; N>9 ; ++j){
      N=Next(N);
      //cout <<N<<endl;
    }
   
    cout << j << endl;;
  }
}