#include<iostream>
#include<math.h>
using namespace std;
int tejun(int inp,int r);

int main(){
  int q;
  cin>>q;
  for(int i=0;i<q;i++){
    int num;
    cin >> num;
    int r=0;
    r = tejun(num,r);
    cout << r << endl;
  }
}

int tejun(int inp,int r){
  if(inp>9){
    int max=0;
    for(int j=1;pow(10,j)<inp;j++){
      int kake=(inp/(int)pow(10,j))*(inp%(int)pow(10,j));
      if(kake>max){
	max=kake;
      }
    }
    return tejun(max,r+1);
  }
  return r;
}