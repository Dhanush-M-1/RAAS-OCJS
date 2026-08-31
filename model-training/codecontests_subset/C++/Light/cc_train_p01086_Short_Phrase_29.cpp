#include <iostream>
#include <string>
#include <vector>
using namespace std;

int main(){
  while(1){
    int N;
    cin >> N ;
    vector<int> a;
    if(N==0){
      break;
    }
    for(int i=0;i<N;i++){
      string str;
      cin >> str;
      a.push_back(str.size());
    }
    for(int i=0;i<N;i++){
      int tanka=0;
      int sum=0;
      for(int j=i;j<N;j++){
        sum+=a[j];
        if(sum==5&&(tanka==0||tanka==2)||sum==7&&(tanka==1||tanka==3||tanka==4)){
          tanka++;
          sum=0;
        }
      }
      if(tanka==5){
        cout << i+1 << endl;
        break;
      }
    }
  }
}
